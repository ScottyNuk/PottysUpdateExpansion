package net.potty.pupdates.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.entity.custom.WarmChickenEntity;

@Environment(EnvType.CLIENT)
public class WarmChickenRenderer extends MobEntityRenderer<WarmChickenEntity, WarmChickenModel<WarmChickenEntity>> {

    public WarmChickenRenderer(EntityRendererFactory.Context context) {
        super(context, new WarmChickenModel<>(context.getPart(WarmChickenModel.WARM_CHICKEN)), 0.25f);
    }

    @Override
    public Identifier getTexture(WarmChickenEntity entity) {
        return Identifier.of(PottysUpdates.MOD_ID, "textures/entity/warm_chicken.png");
    }
    @Override
    public void render(WarmChickenEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
