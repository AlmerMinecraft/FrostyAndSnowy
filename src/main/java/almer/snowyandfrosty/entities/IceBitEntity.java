package almer.snowyandfrosty.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IceBitEntity extends ExplosiveProjectileEntity implements FlyingItemEntity{
    public IceBitEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public IceBitEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ) {
        super(ModEntityType.ICE_BIT, owner, velocityX, velocityY, velocityZ, world);
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        LivingEntity livingEntity;
        Entity entity;
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(this.getDamageSources().mobProjectile(this, (entity = this.getOwner()) instanceof LivingEntity ? (livingEntity = (LivingEntity)entity) : null), 4.0f);
        if(entityHitResult.getEntity() instanceof LivingEntity){
            LivingEntity livEntity = (LivingEntity)entityHitResult.getEntity();
            livEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 2), livEntity);
        }
    }
    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.discard();
        }
    }
    @Override
    public boolean canHit() {
        return false;
    }
    @Override
    public boolean damage(DamageSource source, float amount) {
        return false;
    }
    @Override
    public ItemStack getStack() {
        return Items.PACKED_ICE.getDefaultStack();
    }
    @Override
    protected boolean isBurning() {
        return false;
    }
    @Override
    public boolean isOnFire() {
        return false;
    }
}
