package mod.qwoopscraft.creativemodetab;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.qwoopscraft;
import mod.qwoopscraft.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

public class ModCreativeModeTabs {

    public static final CreativeModeTab MOD_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID, "mod_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BACON))
                    .title(Component.translatable("creativemodetab.qwoopscraft.mod_items"))
                    .displayItems((parameters, output) -> {
                ModItems.ITEM_ALL.forEach(output::accept);
                output.accept(ModBlocks.PAN);
            }).build());


    public static void RegisterModCreativeModeTabs(){
        qwoopscraft.LOGGER.info("REGISTERING CREATIVE TABS: " + qwoopscraft.MOD_ID);

    }
}
