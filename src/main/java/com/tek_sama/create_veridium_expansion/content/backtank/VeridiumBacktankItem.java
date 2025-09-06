// src/main/java/com/tek_sama/create_veridium_expansion/content/backtank/VeridiumBacktankItem.java
package com.tek_sama.create_veridium_expansion.content.backtank;

import com.tek_sama.create_veridium_expansion.registry.CVEBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class VeridiumBacktankItem extends ArmorItem {
    // tweak these to taste
    public static final int MAX_AIR = 6000; // ticks of air (~5min)
    public static final int TRANSFER_PER_TICK = 4;

    public VeridiumBacktankItem(ArmorMaterial material, Properties props) {
        super(material, Type.CHESTPLATE, props);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag flag) {
        int air = VeridiumBacktankUtil.getAir(stack);
        tooltip.add(Component.translatable("tooltip.create_veridium_expansion.backtank.air",
                air, MAX_AIR).withStyle(ChatFormatting.AQUA));

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.create_veridium_expansion.backtank.desc.line1")
                    .withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.create_veridium_expansion.backtank.desc.line2")
                    .withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("tooltip.create_veridium_expansion.hold_shift")
                    .withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        // place as a block when used on a face (like Create backtanks)
        var level = ctx.getLevel();
        var pos = ctx.getClickedPos().relative(ctx.getClickedFace());
        var player = ctx.getPlayer();
        ItemStack stack = ctx.getItemInHand();

        if (player == null) return InteractionResult.PASS;
        if (!level.getBlockState(pos).canBeReplaced()) return InteractionResult.PASS;

        var state = CVEBlocks.VERIDIUM_BACKTANK.get().defaultBlockState();
        if (level.setBlock(pos, state, 3)) {
            if (!player.isCreative()) stack.shrink(1);
            // store air into placed block entity
            var be = level.getBlockEntity(pos);
            if (be instanceof VeridiumBacktankBlockEntity tankBe) {
                tankBe.setAir(VeridiumBacktankUtil.getAir(stack));
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // quick-equip to chest slot if empty
        ItemStack stack = player.getItemInHand(hand);
        if (player.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            player.setItemSlot(EquipmentSlot.CHEST, stack.copy());
            if (!player.isCreative()) stack.shrink(1);
            return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
        }
        return super.use(level, player, hand);
    }
}
