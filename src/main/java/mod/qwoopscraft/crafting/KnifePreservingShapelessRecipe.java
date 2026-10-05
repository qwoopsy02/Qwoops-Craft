package mod.qwoopscraft.crafting;

import com.mojang.serialization.MapCodec;
import mod.qwoopscraft.item.ModItems;
import mod.qwoopscraft.qwoopscraft;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.level.Level;

import java.util.List;

public final class KnifePreservingShapelessRecipe implements CraftingRecipe {
    private static final MapCodec<KnifePreservingShapelessRecipe> CODEC =
            ShapelessRecipe.MAP_CODEC.xmap(KnifePreservingShapelessRecipe::new, recipe -> recipe.recipe);
    private static final StreamCodec<RegistryFriendlyByteBuf, KnifePreservingShapelessRecipe> STREAM_CODEC =
            ShapelessRecipe.STREAM_CODEC.map(KnifePreservingShapelessRecipe::new, recipe -> recipe.recipe);
    public static final RecipeSerializer<KnifePreservingShapelessRecipe> SERIALIZER =
            new RecipeSerializer<>(CODEC, STREAM_CODEC);

    private final ShapelessRecipe recipe;

    public KnifePreservingShapelessRecipe(ShapelessRecipe recipe) {
        this.recipe = recipe;
    }

    public static void register() {
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER,
                Identifier.fromNamespaceAndPath(qwoopscraft.MOD_ID, "knife_preserving_shapeless"), SERIALIZER);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        return recipe.matches(input, level);
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        return recipe.assemble(input);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> remainingItems = CraftingRecipe.defaultCraftingReminder(input);
        for (int i = 0; i < input.size(); i++) {
            ItemStack ingredient = input.getItem(i);
            if (ingredient.is(ModItems.KNIFE))  {
                ItemStack knife = ingredient.copy();
                knife.setCount(1);
                if (!knife.nextDamageWillBreak()) {
                    knife.setDamageValue(knife.getDamageValue() + 1);
                    remainingItems.set(i, knife);
                }
            } else if (ingredient.is(Items.MILK_BUCKET)) {
                remainingItems.set(i, new ItemStack(Items.BUCKET));
            }else if (ingredient.is(ModItems.MIXER))  {
                ItemStack mixer = ingredient.copy();
                mixer.setCount(1);
                if (!mixer.nextDamageWillBreak()) {
                    mixer.setDamageValue(mixer.getDamageValue() + 1);
                    remainingItems.set(i, mixer);
                }
            }
        }
        return remainingItems;
    }

    @Override
    public boolean showNotification() {
        return recipe.showNotification();
    }

    @Override
    public String group() {
        return recipe.group();
    }

    @Override
    public List<RecipeDisplay> display() {
        return recipe.display();
    }

    @Override
    public RecipeSerializer<? extends CraftingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public PlacementInfo placementInfo() {
        return recipe.placementInfo();
    }

    @Override
    public CraftingBookCategory category() {
        return recipe.category();
    }
}
