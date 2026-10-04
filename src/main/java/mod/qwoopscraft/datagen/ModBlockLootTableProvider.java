package mod.qwoopscraft.datagen;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.block.custom.rice;
import mod.qwoopscraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.PAN);
        this.add(ModBlocks.RICE_CROP, this.createCropDrops(ModBlocks.RICE_CROP, ModItems.RICE_SHOOT, ModItems.RICE_SHOOT,
                MatchBlock.blockMatches(blocks, ModBlocks.RICE_CROP,
                        StatePropertiesPredicate.Builder.properties().hasProperty(rice.AGE, rice.MAX_AGE))));
    }
}
