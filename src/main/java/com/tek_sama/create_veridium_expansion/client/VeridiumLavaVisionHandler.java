package com.tek_sama.create_veridium_expansion.client;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import com.tek_sama.create_veridium_expansion.registry.CVEItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateVeridiumExpansion.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VeridiumLavaVisionHandler {

    private static boolean wearingVeridiumDivingHelmet() {
        var p = Minecraft.getInstance().player;
        return p != null && p.getItemBySlot(EquipmentSlot.HEAD).is(CVEItems.VERIDIUM_DIVING_HELMET.get());
    }

    @SubscribeEvent
    public static void onFogColor(ViewportEvent.ComputeFogColor e) {
        var p = Minecraft.getInstance().player;
        if (p == null || !p.isInLava() || !wearingVeridiumDivingHelmet()) return;

        // Slightly brighten lava tint
        e.setRed(Math.min(1.0f, e.getRed() * 0.85f + 0.15f));
        e.setGreen(Math.min(1.0f, e.getGreen() * 0.65f + 0.15f));
        e.setBlue(Math.min(1.0f, e.getBlue() * 0.45f + 0.10f));
    }

    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog e) {
        var p = Minecraft.getInstance().player;
        if (p == null || !p.isInLava() || !wearingVeridiumDivingHelmet()) return;

        // Push fog far plane to see better in lava
        e.setNearPlaneDistance(0.0F);
        e.setFarPlaneDistance(24.0F);
        e.setCanceled(true);
    }
}
