// src/main/java/com/tek_sama/create_veridium_expansion/registry/CVEBlockEntities.java
package com.tek_sama.create_veridium_expansion.registry;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import com.tek_sama.create_veridium_expansion.content.backtank.VeridiumBacktankBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CVEBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreateVeridiumExpansion.MOD_ID);

    public static final RegistryObject<BlockEntityType<VeridiumBacktankBlockEntity>> VERIDIUM_BACKTANK =
            BLOCK_ENTITIES.register("veridium_backtank",
                    () -> BlockEntityType.Builder.of(VeridiumBacktankBlockEntity::new, CVEBlocks.VERIDIUM_BACKTANK.get()).build(null));
}
