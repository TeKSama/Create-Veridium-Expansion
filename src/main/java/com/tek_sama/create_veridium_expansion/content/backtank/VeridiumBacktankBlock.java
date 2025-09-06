// src/main/java/com/tek_sama/create_veridium_expansion/content/backtank/VeridiumBacktankBlock.java
package com.tek_sama.create_veridium_expansion.content.backtank;

import com.tek_sama.create_veridium_expansion.registry.CVEBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class VeridiumBacktankBlock extends Block implements EntityBlock {
    public VeridiumBacktankBlock(Properties p) {
        super(p);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CVEBlockEntities.VERIDIUM_BACKTANK.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == CVEBlockEntities.VERIDIUM_BACKTANK.get() ?
                (lvl, pos, st, be) -> VeridiumBacktankBlockEntity.tick(lvl, pos, st, (VeridiumBacktankBlockEntity) be) : null;
    }
}
