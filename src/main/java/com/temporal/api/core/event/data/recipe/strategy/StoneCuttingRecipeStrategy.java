package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.holder.StoneCuttingRecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class StoneCuttingRecipeStrategy implements RecipeStrategy<StoneCuttingRecipeHolder> {
    @Override
    public void saveRecipe(StoneCuttingRecipeHolder recipeHolder, @NotNull Consumer<FinishedRecipe> recipeConsumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(recipeHolder.getIngredient()), recipeHolder.getRecipeCategory(), recipeHolder.getResult(), recipeHolder.getCount())
                .save(recipeConsumer);
    }
}
