package almer.snowyandfrosty.entities;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class SnailEntity extends PathAwareEntity {
    public int slimeLayTime = this.random.nextInt(6000) + 6000;
    int moreCropTicks;
    public SnailEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EatCropGoal(this));
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.3f));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }
    public static DefaultAttributeContainer.Builder createSnailAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }
    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.slimeLayTime <= 0) {
            this.dropItem(Items.SLIME_BALL);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.slimeLayTime = this.random.nextInt(6000) + 6000;
        }
    }
    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }
    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
    }
    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }
    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.1f;
    }
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("SlimeLayTime")) {
            this.slimeLayTime = nbt.getInt("SlimeLayTime");
        }
        this.moreCropTicks = nbt.getInt("MoreCarrotTicks");
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("SlimeLayTime", this.slimeLayTime);
        nbt.putInt("MoreCropTicks", this.moreCropTicks);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        if (this.moreCropTicks > 0) {
            this.moreCropTicks -= this.random.nextInt(3);
            if (this.moreCropTicks < 0) {
                this.moreCropTicks = 0;
            }
        }
    }
    boolean wantsCrops() {
        return this.moreCropTicks <= 0;
    }
    @Override
    public boolean damage(DamageSource source, float amount) {
        return super.damage(source, amount);
    }
    static class EatCropGoal extends MoveToTargetPosGoal {
        private final SnailEntity snail;
        private boolean wantsCrop;
        private boolean hasTarget;

        public EatCropGoal(SnailEntity snail) {
            super(snail, 0.3f, 16);
            this.snail = snail;
        }

        @Override
        public boolean canStart() {
            if (this.cooldown <= 0) {
                if (!this.snail.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    return false;
                }
                this.hasTarget = false;
                this.wantsCrop = this.snail.wantsCrops();
            }
            return super.canStart();
        }

        @Override
        public boolean shouldContinue() {
            return this.hasTarget && super.shouldContinue();
        }

        @Override
        public void tick() {
            super.tick();
            this.snail.getLookControl().lookAt((double)this.targetPos.getX() + 0.5, this.targetPos.getY() + 1, (double)this.targetPos.getZ() + 0.5, 10.0f, this.snail.getMaxLookPitchChange());
            if (this.hasReached()) {
                World world = this.snail.getWorld();
                BlockPos blockPos = this.targetPos.up();
                BlockState blockState = world.getBlockState(blockPos);
                Block block = blockState.getBlock();
                if (this.hasTarget && block instanceof CropBlock) {
                    int i = blockState.get(CropBlock.AGE);
                    if (i == 0) {
                        world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                        world.breakBlock(blockPos, true, this.snail);
                    } else {
                        world.setBlockState(blockPos, (BlockState)blockState.with(CropBlock.AGE, i - 1), Block.NOTIFY_LISTENERS);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(this.snail));
                        world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(blockState));
                    }
                    this.snail.moreCropTicks = 80;
                }
                this.hasTarget = false;
                this.cooldown = 10;
            }
        }

        @Override
        protected boolean isTargetPos(WorldView world, BlockPos pos) {
            BlockState blockState = world.getBlockState(pos);
            if (blockState.isOf(Blocks.FARMLAND) && this.wantsCrop && !this.hasTarget && (blockState = world.getBlockState(pos.up())).getBlock() instanceof CropBlock && ((CropBlock)blockState.getBlock()).isMature(blockState)) {
                this.hasTarget = true;
                return true;
            }
            return false;
        }
    }
}
