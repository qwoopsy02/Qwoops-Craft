package mod.qwoopscraft.worldgen;

import mod.qwoopscraft.qwoopscraft;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class ModWorldGeneration {
    private static final ResourceKey<PlacedFeature> RICE_PATCH = ResourceKey.create(
            Registries.PLACED_FEATURE, qwoopscraft.id("rice_patch"));

    private ModWorldGeneration() {
    }

    public static void register() {
        BiomeModifications.addFeature(
                BiomeSelectors.all(),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                RICE_PATCH);
    }
}
