package mod.qwoopscraft.datagen;

import mod.qwoopscraft.block.ModBlocks;
import mod.qwoopscraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

                oreSmelting(RICE_SMELTABLES, RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.COOKED_RICE_BOWL, 0.1f, 60, "rice");

            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "TutorialMod Recipes";
    }
}