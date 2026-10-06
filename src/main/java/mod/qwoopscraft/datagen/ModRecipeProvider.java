package mod.qwoopscraft.datagen;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.crafting.KnifePreservingShapelessRecipe;
import mod.qwoopscraft.item.ModItems;
import mod.qwoopscraft.qwoopscraft;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries,
                                                           @NonNull BootstrapContext<Recipe<?>> recipes,
                                                           @NonNull BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                List<ItemLike> RICE_SMELTABLES = List.of(ModItems.CLEAN_RICE_BOWL);
                List<ItemLike> BACON_SMELTABLES = List.of(ModItems.BACON_RAW);
                RecipeOutput knifePreservingOutput = new RecipeOutput() {
                    @Override
                    public void accept(net.minecraft.resources.ResourceKey<Recipe<?>> key, Recipe<?> recipe,
                                       AdvancementHolder advancement) {
                        if (recipe instanceof ShapelessRecipe shapelessRecipe) {
                            output.accept(key, new KnifePreservingShapelessRecipe(shapelessRecipe), advancement);
                        } else {
                            output.accept(key, recipe, advancement);
                        }
                    }

                    @Override
                    public Advancement.Builder advancement() {
                        return output.advancement();
                    }

                    @Override
                    public <S> HolderGetter<S> lookup(ResourceKey<? extends Registry<? extends S>> registryKey) {
                        return output.lookup(registryKey);
                    }

                    @Override
                    public <S> Stream<Holder.Reference<S>> listContextElements(
                            ResourceKey<? extends Registry<? extends S>> registryKey) {
                        return output.listContextElements(registryKey);
                    }
                };

                oreSmelting(RICE_SMELTABLES, RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.COOKED_RICE_BOWL, 0.1f, 60, "rice");
                oreSmelting(BACON_SMELTABLES, RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.BACON, 0.1f, 60, "bacon");
                shapeless(RecipeCategory.MISC, ModItems.BACON_RICE_BOWL, 1)
                        .requires(ModItems.BACON)
                        .requires(ModItems.COOKED_RICE_BOWL)
                        .unlockedBy(getHasName(ModItems.BACON), has(ModItems.BACON))
                        .unlockedBy(getHasName(ModItems.COOKED_RICE_BOWL), has(ModItems.COOKED_RICE_BOWL))
                        .group("rice")
                        .save(output, "bacon_rice_bowl_recipe");
                shapeless(RecipeCategory.MISC, ModItems.LOOSE_RICE, 2)
                        .requires(ModItems.RICE_SHOOT)
                        .requires(ModItems.KNIFE)
                        .unlockedBy(getHasName(ModItems.RICE_SHOOT), has(ModItems.RICE_SHOOT))
                        .unlockedBy(getHasName(ModItems.KNIFE), has(ModItems.KNIFE))
                        .group("rice")
                        .save(knifePreservingOutput, ResourceKey.create(
                                Registries.RECIPE, qwoopscraft.id("loose_rice_recipe")));
                shapeless(RecipeCategory.MISC, ModItems.BACON_RAW, 2)
                        .requires(Items.PORKCHOP)
                        .requires(ModItems.KNIFE)
                        .unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
                        .unlockedBy(getHasName(ModItems.KNIFE), has(ModItems.KNIFE))
                        .group("rice")
                        .save(knifePreservingOutput, ResourceKey.create(
                                Registries.RECIPE, qwoopscraft.id("raw_bacon_recipe")));
                shapeless(RecipeCategory.MISC, ModItems.PATTY_RAW, 2)
                        .requires(Items.BEEF)
                        .requires(ModItems.KNIFE)
                        .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                        .unlockedBy(getHasName(ModItems.KNIFE), has(ModItems.KNIFE))
                        .group("burger")
                        .save(knifePreservingOutput, ResourceKey.create(
                                Registries.RECIPE, qwoopscraft.id("patty_recipe")));
                shapeless(RecipeCategory.MISC, ModItems.CHEESE, 2)
                        .requires(Items.MILK_BUCKET)
                        .requires(ModItems.MIXER)
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .unlockedBy(getHasName(ModItems.MIXER), has(ModItems.MIXER))
                        .group("cheese")
                        .save(knifePreservingOutput, ResourceKey.create(
                                Registries.RECIPE, qwoopscraft.id("cheese_recipe")));
                shapeless(RecipeCategory.MISC, ModItems.UNCLEAN_RICE_BOWL, 1)
                        .requires(ModItems.LOOSE_RICE)
                        .requires(Items.BOWL)
                        .unlockedBy(getHasName(ModItems.LOOSE_RICE), has(ModItems.LOOSE_RICE))
                        .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                        .group("rice")
                        .save(output, "unclean_rice_bowl_recipe");
                shaped(RecipeCategory.MISC, ModItems.KNIFE)
                        .pattern("I  ")
                        .pattern(" T ")
                        .pattern("  S")
                        .define('I',Items.IRON_INGOT)
                        .define('T',Items.STRING)
                        .define('S',Items.STICK)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("tools")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.BURGER)
                        .pattern(" B ")
                        .pattern(" P ")
                        .pattern(" B ")
                        .define('B',Items.BREAD)
                        .define('P',ModItems.PATTY)
                        .unlockedBy(getHasName(ModItems.PATTY), has(ModItems.PATTY))
                        .save(output, "burger_recipe");
                shapeless(RecipeCategory.MISC, ModItems.BURGER_CHEESE, 1)
                        .requires(ModItems.BURGER)
                        .requires(ModItems.CHEESE)
                        .unlockedBy(getHasName(ModItems.BURGER), has(ModItems.BURGER))
                        .group("burger")
                        .save(output, "burger_cheese_recipe");


            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "TutorialMod Recipes";
    }
}