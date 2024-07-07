package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.ShapedRecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;

public class ShapedRecipeStrategy implements RecipeStrategy<ShapedRecipeHolder> {
    @Override
    public void saveRecipe(ShapedRecipeHolder shapedRecipeHolder, @NotNull Consumer<FinishedRecipe> recipeConsumer) {
        String[] pattern = shapedRecipeHolder.getPattern();
        final Map<Character, ItemLike> patternTranslation = shapedRecipeHolder.getPatternTranslation();
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(shapedRecipeHolder.getRecipeCategory(), shapedRecipeHolder.getResult(), shapedRecipeHolder.getCount());
        for (String line : pattern) builder = builder.pattern(line);
        for (var translation : patternTranslation.entrySet()) builder = builder.define(translation.getKey(), translation.getValue());
        for (ItemLike item : patternTranslation.values()) builder = builder.unlockedBy(ApiRecipeProvider.getHasName(item), ApiRecipeProvider.has(item));
        builder.save(recipeConsumer);
    }
}
