package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.SmithingTrimRecipeHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public class SmithingTrimRecipeStrategy implements RecipeStrategy<SmithingTrimRecipeHolder> {
    @Override
    public void saveRecipe(SmithingTrimRecipeHolder recipeHolder, @NotNull Consumer<FinishedRecipe> recipeConsumer) {
        SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(recipeHolder.getTemplate()), Ingredient.of(recipeHolder.getBase()), Ingredient.of(recipeHolder.getAddition()), recipeHolder.getRecipeCategory())
                .unlocks(ApiRecipeProvider.getHasName(recipeHolder.getTemplate()), ApiRecipeProvider.has(recipeHolder.getTemplate()))
                .save(recipeConsumer, new ResourceLocation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(recipeHolder.getResult().asItem()))
                        .getPath()));
    }
}
