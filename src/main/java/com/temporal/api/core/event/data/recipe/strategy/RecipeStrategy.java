package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.holder.RecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface RecipeStrategy<T extends RecipeHolder> {
    void saveRecipe(T t, @NotNull Consumer<FinishedRecipe> recipeConsumer);
}
