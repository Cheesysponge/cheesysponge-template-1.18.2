package name.cheesysponge.world.gen;

import name.cheesysponge.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, ModEntities.CHEESE, 500, 3, 5);

        SpawnRestriction.register(ModEntities.CHEESE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TameableEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                SpawnGroup.CREATURE, ModEntities.CHEESE_BOSS, 300, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT,BiomeKeys.BADLANDS),
                SpawnGroup.CREATURE, ModEntities.CHEESE_BIRD, 200, 1, 1);

        SpawnRestriction.register(ModEntities.CHEESE_BOSS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TameableEntity::isValidNaturalSpawn);
    }
}