package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.holder.ShapelessRecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ShapelessRecipeStrategy implements RecipeStrategy<ShapelessRecipeHolder> {
    @Override
    public void saveRecipe(ShapelessRecipeHolder shapelessRecipeHolder, @NotNull Consumer<FinishedRecipe> recipeConsumer) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(shapelessRecipeHolder.getRecipeCategory(), shapelessRecipeHolder.getResult(), shapelessRecipeHolder.getCount());
        for (var entry : shapelessRecipeHolder.getItemAndCountMap().entrySet()) builder = builder.requires(entry.getKey(), entry.getValue());
        builder.save(recipeConsumer);
    }
}
