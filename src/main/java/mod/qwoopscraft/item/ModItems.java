package mod.qwoopscraft.item;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.foods.ModFoods;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import mod.qwoopscraft.qwoopscraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;

import java.util.function.Function;


public class ModItems {
    public static final Item BACON = registerItem("bacon_ingredient",
            properties -> new Item(properties.food(ModFoods.BACON,ModFoods.BACON_CONSUME)));
    public static final Item RICE_SHOOT = registerItem("rice_shoot",
            properties -> new PlaceOnWaterBlockItem(ModBlocks.RICE_CROP, properties.useItemDescriptionPrefix()));
    public static final Item LOOSE_RICE = registerItem("loose_rice",
            properties -> new Item(properties.food(ModFoods.UNCLEAN_RICE,ModFoods.UNCLEAN_RICE_CONSUME)));
    public static final Item COOKED_RICE_BOWL = registerItem("cooked_rice_bowl",
            properties -> new Item(properties.food(ModFoods.COOKED_RICE,ModFoods.COOKED_RICE_CONSUME)));
    public static final Item UNCLEAN_RICE_BOWL = registerItem("unclean_rice_bowl",
            properties -> new Item(properties.food(ModFoods.UNCLEAN_RICE,ModFoods.UNCLEAN_RICE_CONSUME)));
    public static final Item CLEAN_RICE_BOWL = registerItem("clean_rice_bowl",
            properties -> new Item(properties.food(ModFoods.CLEAN_RICE,ModFoods.CLEAN_RICE_CONSUME)));
    public static final Item BACON_RICE_BOWL = registerItem("bacon_rice_bowl",
            properties -> new Item(properties.food(ModFoods.COOKED_BACON_RICE,ModFoods.COOKED_BACON_RICE_CONSUME)));
    public static final Item KNIFE = registerItem("knife", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        Identifier id = Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID, name);
        Item item = function.apply(new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, id)));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        qwoopscraft.LOGGER.info("REGISTERING ITEMS " + qwoopscraft.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.accept(BACON);
            output.accept(RICE_SHOOT);
        });
    }
}