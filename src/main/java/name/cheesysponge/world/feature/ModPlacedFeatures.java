package name.cheesysponge.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> SPONGE_PLACED = PlacedFeatures.register("sponge_placed",
            ModConfiguredFeatures.SPONGE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
    public static final RegistryEntry<PlacedFeature> CHEESY_SPONGE_FLOWER_PLACED = PlacedFeatures.register("cheesy_sponge_flower_placed",
            ModConfiguredFeatures.CHEESY_SPONGE_FLOWER, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> CHEESYSPONGE_ORE_PLACED = PlacedFeatures.register("cheesysponge_ore_placed",
            ModConfiguredFeatures.CHEESYSPONGE_ORE, ModOreFeatures.modifiersWithCount(2,//veins per chunk
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-60), YOffset.aboveBottom(80))));

}