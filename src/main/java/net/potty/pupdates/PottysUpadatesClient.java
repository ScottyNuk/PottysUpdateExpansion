package net.potty.pupdates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.potty.pupdates.block.ModBlocks;
import net.potty.pupdates.entity.ModEntities;
import net.potty.pupdates.entity.client.ColdChickenModel;
import net.potty.pupdates.entity.client.ColdChickenRenderer;
import net.potty.pupdates.entity.client.WarmChickenModel;
import net.potty.pupdates.entity.client.WarmChickenRenderer;
import net.potty.pupdates.particle.FireflyParticle;
import net.potty.pupdates.particle.ModParticles;
import net.potty.pupdates.screen.ModScreenHandlers;
import net.potty.pupdates.screen.custom.UpdateAltarScreen;

public class PottysUpadatesClient implements ClientModInitializer {

    public static final EntityModelLayer COLD_CHICKEN_LAYER =
            new EntityModelLayer(Identifier.of("pupdates", "cold_chicken"), "main");

    public static final EntityModelLayer WARM_CHICKEN_LAYER =
            new EntityModelLayer(Identifier.of("pupdates", "warm_chicken"), "main");

    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.UPDATE_ALTAR, UpdateAltarScreen::new);




        // Particle
        ParticleFactoryRegistry.getInstance().register(ModParticles.FIREFLY, FireflyParticle.Factory::new);

        // Block render layers
        BlockRenderLayerMap map = BlockRenderLayerMap.INSTANCE;

        map.putBlock(ModBlocks.PALE_OAK_SAPLING, RenderLayer.getCutout());
        map.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
        map.putBlock(ModBlocks.HANGING_PALE_MOSS, RenderLayer.getCutout());

        map.putBlock(ModBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        map.putBlock(ModBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());

        map.putBlock(ModBlocks.PALE_SHORT_GRASS, RenderLayer.getCutout());
        map.putBlock(ModBlocks.PALE_TALL_GRASS, RenderLayer.getCutout());

        map.putBlock(ModBlocks.FIREFLY_BUSH, RenderLayer.getCutout());
        map.putBlock(ModBlocks.DEAD_FIREFLY_BUSH, RenderLayer.getCutout());

        map.putBlock(ModBlocks.LEAF_LITTER, RenderLayer.getCutout());
        map.putBlock(ModBlocks.DARK_LEAF_LITTER, RenderLayer.getCutout());
        map.putBlock(ModBlocks.DRY_LEAF_LITTER, RenderLayer.getCutout());
        map.putBlock(ModBlocks.FRESH_LEAF_LITTER, RenderLayer.getCutout());
        map.putBlock(ModBlocks.CHERRY_LEAF_LITTER, RenderLayer.getCutout());
        map.putBlock(ModBlocks.PALE_LEAF_LITTER, RenderLayer.getCutout());
        map.putBlock(ModBlocks.AUTUMN_LEAF_LITTER, RenderLayer.getCutout());

        map.putBlock(ModBlocks.RESIN_CLUMP, RenderLayer.getCutout());

        map.putBlock(ModBlocks.CREAKING_HEART, RenderLayer.getCutout());

        map.putBlock(ModBlocks.PEBBLE_PATH, RenderLayer.getCutout());
        map.putBlock(ModBlocks.MOSSY_PEBBLE_PATH, RenderLayer.getCutout());
        map.putBlock(ModBlocks.DEEPSLATE_PEBBLE_PATH, RenderLayer.getCutout());
        map.putBlock(ModBlocks.WILDFLOWERS, RenderLayer.getCutout());
        map.putBlock(ModBlocks.BUSH, RenderLayer.getCutout());
        map.putBlock(ModBlocks.CACTUS_FLOWER, RenderLayer.getCutout());

        map.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getTranslucent());
        map.putBlock(ModBlocks.MAPLE_TRAP_DOOR, RenderLayer.getTranslucent());
        map.putBlock(ModBlocks.AUTUMN_MAPLE_DOOR, RenderLayer.getTranslucent());
        map.putBlock(ModBlocks.AUTUMN_MAPLE_TRAP_DOOR, RenderLayer.getTranslucent());
        map.putBlock(ModBlocks.PALE_OAK_TRAP_DOOR, RenderLayer.getTranslucent());

        map.putBlock(ModBlocks.UPDATE_ALTAR, RenderLayer.getCutout());
        map.putBlock(ModBlocks.UPDATE_ALTAR, RenderLayer.getTranslucent());


        EntityModelLayerRegistry.registerModelLayer(ColdChickenModel.COLD_CHICKEN, ColdChickenModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.COLD_CHICKEN, ColdChickenRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(WarmChickenModel.WARM_CHICKEN, WarmChickenModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.WARM_CHICKEN, WarmChickenRenderer::new);




    }
}
