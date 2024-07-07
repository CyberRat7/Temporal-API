package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public interface CampfireCookingRecipeHolder extends CookingRecipeHolder {
    @Override
    default RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return RecipeSerializer.CAMPFIRE_COOKING_RECIPE;
    }

    @Override
    default String getRecipeName() {
        return "_from_campfire_cooking";
    }

    @Override
    default int getCount() {
        return 1;
    }
}
