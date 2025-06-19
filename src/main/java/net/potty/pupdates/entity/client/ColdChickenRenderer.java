package net.potty.pupdates.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.entity.custom.ColdChickenEntity;

@Environment(EnvType.CLIENT)
public class ColdChickenRenderer extends MobEntityRenderer<ColdChickenEntity, ColdChickenModel<ColdChickenEntity>> {

    public ColdChickenRenderer(EntityRendererFactory.Context context) {
        super(context, new ColdChickenModel<>(context.getPart(ColdChickenModel.COLD_CHICKEN)), 0.25f);
    }

    @Override
    public Identifier getTexture(ColdChickenEntity entity) {
        return Identifier.of(PottysUpdates.MOD_ID, "textures/entity/cold_chicken.png");
    }
    @Override
    public void render(ColdChickenEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
