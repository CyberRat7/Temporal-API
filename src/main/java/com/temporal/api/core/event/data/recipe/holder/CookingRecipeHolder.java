package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public interface CookingRecipeHolder extends RecipeHolder {
    ItemLike getIngredient();

    float getExperience();

    int getCookingTime();

    RecipeSerializer<? extends AbstractCookingRecipe> getSerializer();

    String getGroup();

    String getRecipeName();
}
