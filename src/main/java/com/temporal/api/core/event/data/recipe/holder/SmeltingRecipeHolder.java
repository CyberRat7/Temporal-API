package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public interface SmeltingRecipeHolder extends CookingRecipeHolder {
    @Override
    default RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return RecipeSerializer.SMELTING_RECIPE;
    }

    @Override
    default String getRecipeName() {
        return "_from_smelting";
    }

    @Override
    default int getCount() {
        return 1;
    }
}
