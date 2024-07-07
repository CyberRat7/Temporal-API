package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.CookingRecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CookingRecipeStrategy implements RecipeStrategy<CookingRecipeHolder> {
    @Override
    public void saveRecipe(CookingRecipeHolder recipeHolder, @NotNull Consumer<FinishedRecipe> recipeConsumer) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(recipeHolder.getIngredient()), recipeHolder.getRecipeCategory(), recipeHolder.getResult(),
                        recipeHolder.getExperience(), recipeHolder.getCookingTime(), recipeHolder.getSerializer())
                .group(recipeHolder.getGroup())
                .unlockedBy(ApiRecipeProvider.getHasName(recipeHolder.getIngredient()), ApiRecipeProvider.has(recipeHolder.getIngredient()))
                .save(recipeConsumer,  IOLayer.FORGE_MOD.getModId() + ":" + ApiRecipeProvider.getItemName(recipeHolder.getResult()) + recipeHolder.getRecipeName() + "_" + ApiRecipeProvider.getItemName(recipeHolder.getIngredient()));

    }
}
