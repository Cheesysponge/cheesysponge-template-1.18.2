package name.cheesysponge;

import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.entity.ModEntities;
import name.cheesysponge.entity.client.CheeseBirdRenderer;
import name.cheesysponge.entity.client.CheeseBossRenderer;
import name.cheesysponge.entity.client.CheeseRenderer;
import name.cheesysponge.fluid.ModFluids;
import name.cheesysponge.particle.ModParticles;
import name.cheesysponge.particle.custom.CheeseParticle;
import name.cheesysponge.screen.CheeseBlasterScreen;
import name.cheesysponge.screen.ModScreenHandlers;
import name.cheesysponge.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class CheesyClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESY_SPONGE_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESY_SPONGE_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESY_SPONGE_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CHEESY_SPONGE_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPONGE_WEED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESY_SPONGE_GLASS, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPONGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPONGE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESE_BLASTER , RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESE_BLASTER, RenderLayer.getTranslucent());
        ModModelPredicateProvider.registerModModels();

        ScreenRegistry.register(ModScreenHandlers.CHEESE_BLASTER_SCREEN_HANDLER, CheeseBlasterScreen::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CHEESE_PARTICLE, CheeseParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.CHEESE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xe9860c));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.CHEESE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xe9860c));
        EntityRendererRegistry.register(ModEntities.CHEESE, CheeseRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHEESE_BOSS, CheeseBossRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHEESE_BIRD, CheeseBirdRenderer::new);

    }
}