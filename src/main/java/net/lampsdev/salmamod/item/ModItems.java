package net.lampsdev.salmamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lampsdev.salmamod.SalmaMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLACK_FUR = registerItem("black_fur", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SalmaMod.MOD_ID,"black_fur")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SalmaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SalmaMod.LOGGER.info("Registering mod items for " + SalmaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLACK_FUR);
        });
    }
}
