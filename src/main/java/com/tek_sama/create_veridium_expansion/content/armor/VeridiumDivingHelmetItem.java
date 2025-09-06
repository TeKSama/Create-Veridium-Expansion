package com.tek_sama.create_veridium_expansion.content.armor;

import com.tek_sama.create_veridium_expansion.content.backtank.VeridiumBacktankItem;
import com.tek_sama.create_veridium_expansion.content.backtank.VeridiumBacktankUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VeridiumDivingHelmetItem extends ArmorItem {
    public VeridiumDivingHelmetItem(ArmorMaterial material, Type type, Item.Properties props) {
        super(material, type, props);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide) return;

        boolean inFluid = player.isInWaterOrBubble() || player.isInLava();
        if (!inFluid)
            return;

        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chest.getItem() instanceof VeridiumBacktankItem))
            return;

        if (VeridiumBacktankUtil.getAir(chest) <= 0)
            return;

        if (level.getGameTime() % 20 == 0)
            if (!VeridiumBacktankUtil.tryConsumeAir(chest, 1))
                return;

        if (player.getAirSupply() < player.getMaxAirSupply())
            player.setAirSupply(player.getMaxAirSupply());

        tickEffect(player, MobEffects.NIGHT_VISION, 220, 0);
    }

    private static void tickEffect(Player player, MobEffect effect, int duration, int amplifier) {
        var cur = player.getEffect(effect);
        if (cur == null || cur.getDuration() <= 100) {
            player.addEffect(new MobEffectInstance(effect, duration, amplifier, true, false, true));
        }
    }
}
