// src/main/java/com/tek_sama/create_veridium_expansion/content/backtank/VeridiumBacktankBlock.java
package com.tek_sama.create_veridium_expansion.content.backtank;

import com.tek_sama.create_veridium_expansion.registry.CVEBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VeridiumBacktankBlock extends Block {
    public VeridiumBacktankBlock(Properties p) { super(p); }

    @Override public RenderShape getRenderShape(BlockState s) { return RenderShape.MODEL; }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CVEBlockEntities.VERIDIUM_BACKTANK.get().create(pos, state);
    }
}
