package almer.snowyandfrosty.client.screen;

import almer.snowyandfrosty.recipe.SawmillRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.math.MathHelper;

import java.util.List;

import static almer.snowyandfrosty.FrostyAndSnowy.MOD_ID;

@Environment(value = EnvType.CLIENT)
public class SawmillScreen extends HandledScreen<SawmillScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/gui/container/sawmill.png");
    private static final Identifier SCROLLER_TEXTURE = new Identifier(MOD_ID, "container/sawmill/scroller");
    private static final Identifier SCROLLER_DISABLED_TEXTURE = new Identifier(MOD_ID, "container/sawmill/scroller_disabled");
    private static final Identifier RECIPE_SELECTED_TEXTURE = new Identifier(MOD_ID, "container/sawmill/recipe_selected");
    private static final Identifier RECIPE_HIGHLIGHTED_TEXTURE = new Identifier(MOD_ID, "container/sawmill/recipe_highlighted");
    private static final Identifier RECIPE_DISABLED_TEXTURE = new Identifier(MOD_ID, "container/sawmill/recipe_disabled");
    private static final Identifier RECIPE_TEXTURE = new Identifier(MOD_ID, "container/sawmill/recipe");
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public SawmillScreen(SawmillScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        handler.setContentsChangedListener(this::onInventoryChange);
        --this.titleY;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int yPosAfterScrolling = (int) (41.0f * this.scrollAmount);
        Identifier identifier = this.shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;
        context.drawGuiTexture(identifier, x + 119, y + 15 + yPosAfterScrolling, 12, 15);
        int xPosForRecipe = this.x + 52;
        int yPosForRecipe = this.y + 14;
        int scrollOffset = this.scrollOffset + 12;
        this.renderRecipeBackground(context, mouseX, mouseY, xPosForRecipe, yPosForRecipe, scrollOffset);
        this.renderRecipeIcons(context, xPosForRecipe, yPosForRecipe, scrollOffset);
    }

    @Override
    protected void drawMouseoverTooltip(DrawContext context, int x, int y) {
        super.drawMouseoverTooltip(context, x, y);

        int toolPosX = this.x + 52;
        int toolPosY = this.y + 14;
        int scrollOffset = this.scrollOffset + 12;
        List<RecipeEntry<SawmillRecipe>> availableRecipes = this.handler.getAvailableRecipes();

        for (int l = this.scrollOffset; l < scrollOffset && l < this.handler.getAvailableRecipeCount(); ++l) {
            int m = l - this.scrollOffset;
            int n = toolPosX + m % 4 * 16;
            int o = toolPosY + m / 4 * 18 + 2;
            if (x < n || x >= n + 16 || y < o || y >= o + 18) continue;
            context.drawItemTooltip(this.textRenderer, availableRecipes.get(l).value()
                    .getResult(this.client.world.getRegistryManager()), x, y);
        }

    }

    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int xPosForRecipe,
                                        int yPosForRecipe, int scrollOffset) {
        for (int i = this.scrollOffset; i < scrollOffset && i < this.handler.getAvailableRecipeCount(); ++i) {
            int yPosWithoutScrollOffset = i - this.scrollOffset;
            int k = xPosForRecipe + yPosWithoutScrollOffset % 4 * 16;
            int l = yPosWithoutScrollOffset / 4;
            int m = yPosForRecipe + l * 18 + 2;
            int inputCount = this.handler.inputSlot.getStack().getCount();
            SawmillRecipe recipe = this.handler.getAvailableRecipes().get(i).value();
            Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
            int requiredInputCount = ingredientPair.getSecond();

            if (inputCount < requiredInputCount) {
                context.drawGuiTexture(RECIPE_DISABLED_TEXTURE, k, m - 1, 16, 18);
            } else {
                renderRecipeBackgroundForCraftableRecipe(context, i, mouseX, mouseY, k, m);
            }
        }
    }

    private void renderRecipeBackgroundForCraftableRecipe(DrawContext context, int i, int mouseX, int mouseY, int k, int m) {
        Identifier identifier = i == this.handler.getSelectedRecipe() ? RECIPE_SELECTED_TEXTURE :
                (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18 ? RECIPE_HIGHLIGHTED_TEXTURE : RECIPE_TEXTURE);
        context.drawGuiTexture(identifier, k, m - 1, 16, 18);
    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        List<RecipeEntry<SawmillRecipe>> availableRecipes = this.handler.getAvailableRecipes();
        for (int i = this.scrollOffset; i < scrollOffset && i < availableRecipes.size(); ++i) {
            int yPosWithoutScrollOffset = i - this.scrollOffset;
            int k = x + yPosWithoutScrollOffset % 4 * 16;
            int l = yPosWithoutScrollOffset / 4;
            int m = y + l * 18 + 2;
            var recipeEntry = availableRecipes.get(i);

            context.drawItem(recipeEntry.value().getResult(this.client.world.getRegistryManager()), k, m);
        }
    }

    //TODO: Needs refactoring
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;
            for (int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = mouseX - (double) (i + m % 4 * 16);
                double e = mouseY - (double) (j + m / 4 * 18);

                if (!(d >= 0.0) || !(e >= 0.0) || !(d < 16.0) || !(e < 18.0) || !(this.handler).onButtonClick(this.client.player, l)) {
                    continue;
                }

                if (this.handler.getAvailableRecipeCount() > l) {
                    SawmillRecipe recipe = this.handler.getAvailableRecipes().get(l).value();
                    Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
                    int requiredInputCount = ingredientPair.getSecond();
                    int inputCount = this.handler.inputSlot.getStack().getCount();

                    if (inputCount < requiredInputCount) {
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 4.0f));
                    } else {
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f));
                    }
                }

                this.client.interactionManager.clickButton((this.handler).syncId, l);
                return true;
            }
            i = this.x + 119;
            j = this.y + 9;
            if (mouseX >= (double) i && mouseX < (double) (i + 12) && mouseY >= (double) j && mouseY < (double) (j + 54)) {
                this.mouseClicked = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.y + 14;
            int j = i + 54;
            this.scrollAmount = ((float) mouseY - (float) i - 7.5f) / ((float) (j - i) - 15.0f);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0f, 1.0f);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) this.getMaxScroll()) + 0.5) * 4;

            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.shouldScroll()) {
            int i = this.getMaxScroll();
            float f = (float) verticalAmount / (float) i;
            this.scrollAmount = MathHelper.clamp(this.scrollAmount - f, 0.0f, 1.0f);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) i) + 0.5) * 4;
        }

        return true;
    }

    private boolean shouldScroll() {
        return this.canCraft && (this.handler).getAvailableRecipeCount() > 12;
    }

    protected int getMaxScroll() {
        return ((this.handler).getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void onInventoryChange() {
        this.canCraft = (this.handler).canCraft();
        if (!this.canCraft) {
            this.scrollAmount = 0.0f;
            this.scrollOffset = 0;
        }
    }
}
