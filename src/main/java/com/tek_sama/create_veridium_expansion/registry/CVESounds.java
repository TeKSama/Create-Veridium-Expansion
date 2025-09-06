package com.tek_sama.create_veridium_expansion.registry;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CVESounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CreateVeridiumExpansion.MOD_ID);

    // -> ID complet: create_veridium_expansion:odst
    public static final RegistryObject<SoundEvent> MUSIC_DISC_ODST = SOUNDS.register(
            "odst",
            () -> SoundEvent.createVariableRangeEvent(
                    new ResourceLocation(CreateVeridiumExpansion.MOD_ID, "odst"))
    );

}
