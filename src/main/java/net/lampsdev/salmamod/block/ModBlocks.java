package net.lampsdev.salmamod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lampsdev.salmamod.SalmaMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SALMA_BLOCK = registerBlock("salma_block",
            AbstractBlock.Settings.create().strength(0.7f).sounds(BlockSoundGroup.WOOL).burnable());


    private static void registerBlockItem(String name, Block block) {

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SalmaMod.MOD_ID, name));

        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));

        Registry.register(Registries.ITEM, key, item);

        SalmaMod.LOGGER.info("Registered BlockItem: " + name); // ADD THIS LINE

    }

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {

        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SalmaMod.MOD_ID, name));

        Block block = new Block(blockSettings.registryKey(key));

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, key, block);

    }


    public static void registerModBlocks() {
        SalmaMod.LOGGER.info("Registering mod blocks for" + SalmaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SALMA_BLOCK);
        });
    }
}
