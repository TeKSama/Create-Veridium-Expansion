package com.tek_sama.create_veridium_expansion.registry;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CVETabs {
    // Le DeferredRegister pour les creative tabs
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateVeridiumExpansion.MOD_ID);

    // Ton onglet principal
    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CVEItems.VERIDIUM_ALLOY_PLATE.get()))
                    .title(Component.translatable("itemGroup.create_veridium_expansion.main"))
                    .displayItems((params, output) -> {
                        // balance ici tous tes items
                        output.accept(CVEItems.VERIDIUM_ALLOY_PLATE_RAW.get());
                        output.accept(CVEItems.VERIDIUM_ALLOY_PLATE.get());
                        output.accept(CVEItems.VERIDIUM_SMITHING_TEMPLATE.get());

                        output.accept(CVEItems.VERIDIUM_HELMET.get());
                        output.accept(CVEItems.VERIDIUM_CHESTPLATE.get());
                        output.accept(CVEItems.VERIDIUM_LEGGINGS.get());
                        output.accept(CVEItems.VERIDIUM_BOOTS.get());
                        output.accept(CVEItems.VERIDIUM_BACKTANK.get());
                        output.accept(CVEItems.VERIDIUM_DIVING_BOOTS.get());
                        output.accept(CVEItems.VERIDIUM_DIVING_HELMET.get());

                        output.accept(CVEItems.MUSIC_DISC_ODST.get());

                        output.accept(CVEItems.VERIDIUM_SWORD.get());
                        output.accept(CVEItems.VERIDIUM_PICKAXE.get());
                        output.accept(CVEItems.VERIDIUM_AXE.get());
                        output.accept(CVEItems.VERIDIUM_SHOVEL.get());
                        output.accept(CVEItems.VERIDIUM_HOE.get());

                    })
                    .build()
    );
}
