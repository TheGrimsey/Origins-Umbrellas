package com.fusionflux.originsumbrellas.items;

import com.fusionflux.originsumbrellas.OriginsUmbrellas;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class UmbrellaItems {
    public static final UmbrellaDyeTest UMBRELLA = new UmbrellaDyeTest(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1).maxDamage(1200));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(OriginsUmbrellas.MOD_ID, "umbrella"), UMBRELLA);
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayers() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem) stack.getItem()).getColor(stack), UmbrellaItems.UMBRELLA);
    }

}
