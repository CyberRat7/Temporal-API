package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.data.model.item.ItemModelProvider;
import com.temporal.api.core.engine.io.metadata.annotation.ItemDataGeneration;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class ItemDataGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(ItemDataGeneration.class)) {
            field.setAccessible(true);
            RegistryObject<Item> registryObject = (RegistryObject<Item>) field.get(object);
            ItemDataGeneration itemDataGeneration = field.getDeclaredAnnotation(ItemDataGeneration.class);
            if (itemDataGeneration.model() != null) {
                ItemDataGeneration.Model model = itemDataGeneration.model();
                switch (model.type()) {
                    case SIMPLE -> ItemModelProvider.ITEMS.add(registryObject);
                    case HANDHELD -> ItemModelProvider.HANDHELD_ITEMS.add(registryObject);
                }
            }
        }
    }
}
