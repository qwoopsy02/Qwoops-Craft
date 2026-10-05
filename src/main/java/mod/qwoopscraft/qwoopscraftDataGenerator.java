package mod.qwoopscraft;

import mod.qwoopscraft.datagen.ModBlockLootTableProvider;
import mod.qwoopscraft.datagen.ModBlockTagsProvider;
import mod.qwoopscraft.datagen.ModModelProvider;
import mod.qwoopscraft.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jspecify.annotations.NonNull;

public class qwoopscraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator( FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
