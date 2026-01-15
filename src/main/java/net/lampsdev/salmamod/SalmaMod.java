package net.lampsdev.salmamod;

import net.fabricmc.api.ModInitializer;

import net.lampsdev.salmamod.block.ModBlocks;
import net.lampsdev.salmamod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalmaMod implements ModInitializer {
	public static final String MOD_ID = "salma-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}