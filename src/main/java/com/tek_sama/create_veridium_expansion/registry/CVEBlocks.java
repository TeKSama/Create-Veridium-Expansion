// src/main/java/com/tek_sama/create_veridium_expansion/registry/CVEBlocks.java
package com.tek_sama.create_veridium_expansion.registry;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import com.tek_sama.create_veridium_expansion.content.backtank.VeridiumBacktankBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CVEBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CreateVeridiumExpansion.MOD_ID);

    public static final RegistryObject<Block> VERIDIUM_BACKTANK =
            BLOCKS.register("veridium_backtank", () -> new VeridiumBacktankBlock(
                    BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5f, 6f).noOcclusion()
            ));
}
