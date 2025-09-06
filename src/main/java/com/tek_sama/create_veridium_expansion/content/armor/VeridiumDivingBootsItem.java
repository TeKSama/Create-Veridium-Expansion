package com.tek_sama.create_veridium_expansion.content.armor;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VeridiumDivingBootsItem extends ArmorItem {
    public VeridiumDivingBootsItem(ArmorMaterial material, Type type, Item.Properties props) {
        super(material, type, props);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide) return;

        if ((player.isInWaterOrBubble() || player.isInLava()) && !player.onGround() && !player.isSpectator()) {
            var v = player.getDeltaMovement();
            double down = player.isInLava() ? -0.12 : -0.10;
            if (v.y > -0.9) {
                player.setDeltaMovement(v.x, v.y + down, v.z);
                player.hurtMarked = true; // force MAJ côté client
            }
        }
    }
}
