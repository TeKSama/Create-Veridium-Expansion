// src/main/java/com/tek_sama/create_veridium_expansion/content/backtank/VeridiumBacktankBlockEntity.java
package com.tek_sama.create_veridium_expansion.content.backtank;

import com.tek_sama.create_veridium_expansion.registry.CVEBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;

public class VeridiumBacktankBlockEntity extends BlockEntity {
    private int air;

    public VeridiumBacktankBlockEntity(BlockPos pos, BlockState state) {
        super(CVEBlockEntities.VERIDIUM_BACKTANK.get(), pos, state);
    }

    public int getAir() { return air; }
    public void setAir(int value) { air = Math.max(0, Math.min(value, VeridiumBacktankItem.MAX_AIR)); setChanged(); }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.putInt("Air", air);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        air = tag.getInt("Air");
    }

    public static void tick(Level level, BlockPos pos, BlockState state, VeridiumBacktankBlockEntity be) {
        if (level.isClientSide)
            return;

        BlockEntity above = level.getBlockEntity(pos.above());
        if (above instanceof KineticBlockEntity kbe && kbe.getSpeed() != 0) {
            be.setAir(be.getAir() + VeridiumBacktankItem.TRANSFER_PER_TICK);
        }
    }
}
