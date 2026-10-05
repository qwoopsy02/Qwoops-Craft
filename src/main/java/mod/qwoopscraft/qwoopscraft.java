package mod.qwoopscraft;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.creativemodetab.ModCreativeModeTabs;
import mod.qwoopscraft.crafting.KnifePreservingShapelessRecipe;
import mod.qwoopscraft.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class qwoopscraft implements ModInitializer {
	public static final String MOD_ID = "qwoopscraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("LOADING " + qwoopscraft.MOD_ID);
		ModCreativeModeTabs.RegisterModCreativeModeTabs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		KnifePreservingShapelessRecipe.register();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
