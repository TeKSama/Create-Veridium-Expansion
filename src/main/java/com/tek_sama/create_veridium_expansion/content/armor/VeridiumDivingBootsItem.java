package com.tek_sama.create_veridium_expansion.content.armor;

import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class VeridiumDivingBootsItem extends ArmorItem {
    public VeridiumDivingBootsItem(ArmorMaterial material, Type type, Item.Properties props) {
        super(material, type, props);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide) return;

        if (!affects(player))
            return;

        Vec3 motion = player.getDeltaMovement();
        player.setOnGround(player.onGround() || player.verticalCollision);
        if (player.onGround()) {
            motion = motion.add(0, .5f, 0);
            player.setOnGround(false);
        } else {
            motion = motion.add(0, -0.05f, 0);
        }

        float multiplier = 1.3f;
        if (motion.multiply(1, 0, 1).length() < 0.145f && (player.zza > 0 || player.xxa != 0) && !player.isShiftKeyDown())
            motion = motion.multiply(multiplier, 1, multiplier);
        player.setDeltaMovement(motion);
    }

    private static boolean affects(Player player) {
        if (!player.isInWater())
            return false;
        if (player.getPose() == Pose.SWIMMING)
            return false;
        if (player.getAbilities().flying)
            return false;
        return true;
    }
}
