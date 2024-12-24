package com.temporal.api.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddSuspiciousSandItemModifier extends LootModifier {
    public static final Supplier<MapCodec<AddSuspiciousSandItemModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(instance -> codecStart(instance)
            .and(ForgeRegistries.ITEMS.getCodec()
                    .fieldOf("item")
                    .forGetter(AddSuspiciousSandItemModifier::getItem))
            .apply(instance, AddSuspiciousSandItemModifier::new)));
    private final Item item;

    public AddSuspiciousSandItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(LootTable lootTable, ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for (LootItemCondition condition : this.conditions)
            if (!condition.test(context)) return generatedLoot;
        if (context.getRandom().nextFloat() < 0.5f) {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(this.getItem()));
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    public Item getItem() {
        return item;
    }
}
