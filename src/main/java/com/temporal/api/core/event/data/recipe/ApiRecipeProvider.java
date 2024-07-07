package com.temporal.api.core.event.data.recipe;

import com.temporal.api.core.event.data.recipe.holder.*;
import com.temporal.api.core.event.data.recipe.strategy.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ApiRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<RecipeHolder> RECIPES = new ArrayList<>();
    private static final RecipeStrategy<ShapelessRecipeHolder> SHAPELESS_RECIPE_STRATEGY = new ShapelessRecipeStrategy();
    private static final RecipeStrategy<ShapedRecipeHolder> SHAPED_RECIPE_STRATEGY = new ShapedRecipeStrategy();
    private static final RecipeStrategy<CookingRecipeHolder> COOKING_RECIPE_STRATEGY  = new CookingRecipeStrategy();
    private static final RecipeStrategy<SmithingTrimRecipeHolder> SMITHING_TRIM_RECIPE_STRATEGY = new SmithingTrimRecipeStrategy();
    private static final RecipeStrategy<SmithingTransformRecipeHolder> SMITHING_TRANSFORM_RECIPE_STRATEGY = new SmithingTransformRecipeStrategy();
    private static final RecipeStrategy<StoneCuttingRecipeHolder> STONE_CUTTING_RECIPE_STRATEGY_RECIPE_STRATEGY = new StoneCuttingRecipeStrategy();

    public ApiRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        RECIPES.forEach(undefinedRecipe -> {
            if (undefinedRecipe instanceof ShapelessRecipeHolder recipe) {
                SHAPELESS_RECIPE_STRATEGY.saveRecipe(recipe, recipeConsumer);
            } else if (undefinedRecipe instanceof ShapedRecipeHolder recipe){
                SHAPED_RECIPE_STRATEGY.saveRecipe(recipe, recipeConsumer);
            } else if (undefinedRecipe instanceof CookingRecipeHolder recipe) {
                COOKING_RECIPE_STRATEGY.saveRecipe(recipe, recipeConsumer);
            } else if (undefinedRecipe instanceof SmithingTrimRecipeHolder recipe) {
                SMITHING_TRIM_RECIPE_STRATEGY.saveRecipe(recipe, recipeConsumer);
            } else if (undefinedRecipe instanceof SmithingTransformRecipeHolder recipe) {
                SMITHING_TRANSFORM_RECIPE_STRATEGY.saveRecipe(recipe, recipeConsumer);
            } else if (undefinedRecipe instanceof StoneCuttingRecipeHolder recipe) {
                STONE_CUTTING_RECIPE_STRATEGY_RECIPE_STRATEGY.saveRecipe(recipe, recipeConsumer);
            }
        });
    }

    public static String getHasName(ItemLike itemLike) {
        return "has_" + getItemName(itemLike);
    }

    public static @NotNull String getItemName(ItemLike itemLike) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemLike.asItem())).getPath();
    }

    public static InventoryChangeTrigger.TriggerInstance has(@NotNull ItemLike itemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(itemLike).build());
    }
}
