package mod.qwoopscraft.datagen;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.block.custom.rice;
import mod.qwoopscraft.item.ModItems;
import mod.qwoopscraft.qwoopscraft;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        Identifier model = qwoopscraft.id("block/pan");
        blockModelGenerators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.PAN, BlockModelGenerators.plainVariant(model))
                        .with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
        blockModelGenerators.registerSimpleItemModel(ModBlocks.PAN, model);
        blockModelGenerators.createCropBlock(ModBlocks.RICE_CROP, rice.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.BACON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.UNCLEAN_RICE_BOWL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CLEAN_RICE_BOWL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LOOSE_RICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BACON_RICE_BOWL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KNIFE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COOKED_RICE_BOWL, ModelTemplates.FLAT_ITEM);
    }
}