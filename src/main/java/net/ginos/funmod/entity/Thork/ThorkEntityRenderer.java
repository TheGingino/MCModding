package net.ginos.funmod.entity.Thork;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ginos.funmod.FunMod;
import net.ginos.funmod.entity.ModEntities;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class ThorkEntityRenderer extends EntityRenderer<ThorkEntity> {
    protected final ThorkEntityModel model;

    public ThorkEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new ThorkEntityModel(context.getPart(ThorkEntityModel.THORK));
    }


    public void render(ThorkEntity trident, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, trident.prevYaw, trident.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, trident.prevPitch, trident.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(Identifier.of(FunMod.MOD_ID, "textures/entity/thork.png")), false, trident.isEnchanted());
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 0);
        matrices.pop();
        super.render(trident, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    public Identifier getTexture(ThorkEntity thorkEntity) {
        return Identifier.of(FunMod.MOD_ID, "textures/entity/thork.png");
    }


}

