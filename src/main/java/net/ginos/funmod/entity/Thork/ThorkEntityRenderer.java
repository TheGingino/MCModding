package net.ginos.funmod.entity.Thork;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ginos.funmod.FunMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class ThorkEntityRenderer extends TridentEntityRenderer {
    public static final Identifier TEXTURE =  Identifier.of(FunMod.MOD_ID, "textures/entity/thork_3d");
    public static final EntityModelLayer THORK_LAYER = new EntityModelLayer(Identifier.of(FunMod.MOD_ID, "thork_3d"), "main");

    private final ThorkEntityModel model;
    public ThorkEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new ThorkEntityModel(context.getPart(THORK_LAYER));
    }

    @Override
    public Identifier getTexture(TridentEntity entity) {
        return TEXTURE;
    }
}
