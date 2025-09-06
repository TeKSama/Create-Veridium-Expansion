// src/main/java/com/tek_sama/create_veridium_expansion/content/backtank/VeridiumBacktankArmorLayer.java
package com.tek_sama.create_veridium_expansion.content.backtank;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

import static com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion.MOD_ID;

public class VeridiumBacktankArmorLayer extends RenderLayer<AbstractClientPlayer, net.minecraft.client.model.PlayerModel<AbstractClientPlayer>> {
    private static final ResourceLocation TANK_TEXTURE =
            new ResourceLocation(MOD_ID, "textures/models/armor/veridium_backtank.png");

    public VeridiumBacktankArmorLayer(LivingEntityRenderer<AbstractClientPlayer, net.minecraft.client.model.PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buf, int light, AbstractClientPlayer player,
                       float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chest.getItem() instanceof VeridiumBacktankItem)) return;

        // bind model (use baked item model or a tiny cube – here we assume an item model)
        var mc = net.minecraft.client.Minecraft.getInstance();
        var model = mc.getItemRenderer().getModel(chest, player.level(), player, 0);

        pose.pushPose();
        // Position the tank on the back (tweak offsets to your liking)
        getParentModel().body.translateAndRotate(pose);
        pose.translate(0.0, 0.75, 0.25);
        pose.scale(1.0f, 1.0f, 1.0f);

        mc.getItemRenderer().render(chest, net.minecraft.world.item.ItemDisplayContext.FIXED,
                false, pose, buf, light, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY, model);

        pose.popPose();
    }
}
