package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.engine.io.resource.InjectedResourceLocation;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public abstract class ApiItemModelProvider extends ItemModelProvider {
    public ApiItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IOLayer.FORGE_MOD.getModId(), existingFileHelper);
    }

    protected ItemModelBuilder registerItem(RegistryObject<Item> itemRegistryObject, String parent) {
        String path = "item/" + itemRegistryObject.getId().getPath();
        return this.withExistingParent(itemRegistryObject.getId().getPath(), new ResourceLocation(parent))
                .texture("layer0", new InjectedResourceLocation(path));
    }
}
