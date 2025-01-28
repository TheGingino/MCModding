package net.ginos.funmod.entity.Thork;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ginos.funmod.FunMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ThorkEntityModel extends EntityModel<ThorkEntity> {

    public static final EntityModelLayer THORK = new EntityModelLayer(Identifier.of(FunMod.MOD_ID, "thork"), "main");
    private final ModelPart pole;
    private final ModelPart base;
    private final ModelPart middleSpike;
    private final ModelPart leftSpike;
    private final ModelPart rightSpike;

    public ThorkEntityModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.pole = root.getChild("pole");
        this.base = root.getChild("base");
        this.middleSpike = root.getChild("middle_spike");
        this.leftSpike = root.getChild("left_spike");
        this.rightSpike = root.getChild("right_spike");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        // Pole
        modelPartData.addChild("pole", ModelPartBuilder.create().uv(0, 6).cuboid(-0.5F, 2.0F, -0.5F, 1.0F, 25.0F, 1.0F), ModelTransform.NONE);
        // Base
        modelPartData.addChild("base", ModelPartBuilder.create().uv(4, 0).cuboid(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 1.0F), ModelTransform.NONE);
        // Middle spike
        modelPartData.addChild("middle_spike", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        // Left spike
        modelPartData.addChild("left_spike", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        // Right spike
        modelPartData.addChild("right_spike", ModelPartBuilder.create().uv(4, 3).mirrored().cuboid(1.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ThorkEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Handle animation if needed
    }



    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        pole.render(matrices, vertices, light, overlay, color);
        base.render(matrices, vertices, light, overlay, color);
        middleSpike.render(matrices, vertices, light, overlay, color);
        leftSpike.render(matrices, vertices, light, overlay, color);
        rightSpike.render(matrices, vertices, light, overlay, color);
    }
}
