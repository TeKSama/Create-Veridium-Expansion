package com.tek_sama.create_veridium_expansion.content.armor;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateVeridiumExpansion.MOD_ID)
public class VeridiumArmorDamageHandler {

    private static final float PER_PIECE_REDUCTION = 0.04f; // 4% par pièce -> 16% full set ≈ Prot II spécialisé

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent e) {
        LivingEntity target = e.getEntity();
        boolean isProjectile = e.getSource().is(DamageTypeTags.IS_PROJECTILE);
        boolean isExplosion  = e.getSource().is(DamageTypeTags.IS_EXPLOSION);
        if (!isProjectile && !isExplosion) return;

        int pieces = 0;
        if (target.getItemBySlot(EquipmentSlot.HEAD).getItem()  instanceof VeridiumArmorItem) pieces++;
        if (target.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof VeridiumArmorItem) pieces++;
        if (target.getItemBySlot(EquipmentSlot.LEGS).getItem()  instanceof VeridiumArmorItem) pieces++;
        if (target.getItemBySlot(EquipmentSlot.FEET).getItem()  instanceof VeridiumArmorItem) pieces++;

        if (pieces <= 0) return;

        float reduction = PER_PIECE_REDUCTION * pieces;
        e.setAmount(e.getAmount() * (1.0f - reduction));
    }
}
