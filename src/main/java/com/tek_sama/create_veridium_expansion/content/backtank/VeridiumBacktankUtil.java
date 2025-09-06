// src/main/java/com/tek_sama/create_veridium_expansion/content/backtank/VeridiumBacktankUtil.java
package com.tek_sama.create_veridium_expansion.content.backtank;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class VeridiumBacktankUtil {
    public static int getAir(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getInt("Air");
    }

    public static void setAir(ItemStack stack, int value) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("Air", Math.max(0, Math.min(value, VeridiumBacktankItem.MAX_AIR)));
    }

    /** drain air per tick to support helmet/boots logic */
    public static boolean tryConsumeAir(ItemStack stack, int amount) {
        int air = getAir(stack);
        if (air <= 0) return false;
        setAir(stack, air - amount);
        return true;
    }
}
