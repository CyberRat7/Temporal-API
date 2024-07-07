package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public interface SmokingRecipeHolder extends CookingRecipeHolder {
    @Override
    default RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return RecipeSerializer.SMOKING_RECIPE;
    }

    @Override
    default String getRecipeName() {
        return "_from_smoking";
    }

    @Override
    default int getCount() {
        return 1;
    }
}
