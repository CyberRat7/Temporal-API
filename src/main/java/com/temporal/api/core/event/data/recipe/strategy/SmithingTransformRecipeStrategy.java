package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.SmithingTransformRecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public class SmithingTransformRecipeStrategy implements RecipeStrategy<SmithingTransformRecipeHolder> {
    @Override
    public void saveRecipe(SmithingTransformRecipeHolder recipeHolder, @NotNull Consumer<FinishedRecipe> recipeConsumer) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(recipeHolder.getTemplate()), Ingredient.of(recipeHolder.getBase()), Ingredient.of(recipeHolder.getAddition()), recipeHolder.getRecipeCategory(), recipeHolder.getResult().asItem())
                .unlocks(ApiRecipeProvider.getHasName(recipeHolder.getTemplate()), ApiRecipeProvider.has(recipeHolder.getTemplate()))
                .save(recipeConsumer, new ResourceLocation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(recipeHolder.getResult().asItem()))
                        .getPath()));
    }
}
