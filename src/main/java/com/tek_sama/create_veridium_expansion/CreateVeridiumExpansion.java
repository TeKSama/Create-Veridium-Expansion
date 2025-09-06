package com.tek_sama.create_veridium_expansion;

import com.tek_sama.create_veridium_expansion.registry.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateVeridiumExpansion.MOD_ID)
public class CreateVeridiumExpansion {
    public static final String MOD_ID = "create_veridium_expansion";

    public CreateVeridiumExpansion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Enregistre TOUTES tes registries ici
        CVEItems.ITEMS.register(modEventBus);
        CVETabs.TABS.register(modEventBus);
        CVESounds.SOUNDS.register(modEventBus);
        CVEBlocks.BLOCKS.register(modEventBus);
        CVEBlockEntities.BLOCK_ENTITIES.register(modEventBus);

    }
}
