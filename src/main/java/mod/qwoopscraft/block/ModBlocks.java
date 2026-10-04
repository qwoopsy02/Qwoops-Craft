package mod.qwoopscraft.block;


import mod.qwoopscraft.block.custom.pan;
import mod.qwoopscraft.qwoopscraft;
import mod.qwoopscraft.block.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
//    public static final Block FLUORITE_END_ORE = registerBlock("fluorite_end_ore",
//            properties -> new DropExperienceBlock(UniformInt.of(4, 8),
//                    properties.strength(6f).requiresCorrectToolForDrops()));
    public static final Block PAN = registerBlock("pan",
            properties -> new pan(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.ANVIL).pushReaction(PushReaction.POPPED)));

    public static final Block RICE_CROP = registerBlockWithoutBlockItem("rice_crop",
            properties -> new rice(properties.noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                    .pushReaction(PushReaction.POPPED)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties,Block> function){
       Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID,name))));
       registerBlockItem(name, toRegister);
       return Registry.register(BuiltInRegistries.BLOCK,Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID,name), toRegister);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID,name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID,name)))));
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID, name), toRegister);
    }
    public static void registerModBlocks(){
        qwoopscraft.LOGGER.info("REGISTERING BLOCKS: " + qwoopscraft.MOD_ID);
    }
}
