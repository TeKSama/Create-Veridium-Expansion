package com.tek_sama.create_veridium_expansion;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }

    public static void register() {
        // Enregistre la config pour que Forge génère le fichier
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue enableVeridiumItems;
        public final ForgeConfigSpec.BooleanValue enableSmithingTemplate;
        public final ForgeConfigSpec.BooleanValue enableFutureContent;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("general");

            enableVeridiumItems = builder
                    .comment("Enable or disable all Veridium items")
                    .define("enableVeridiumItems", true);

            enableSmithingTemplate = builder
                    .comment("Enable or disable the Veridium Smithing Template")
                    .define("enableSmithingTemplate", true);

            enableFutureContent = builder
                    .comment("Toggle experimental/future features (ex: jetpack, potato cannon, etc.)")
                    .define("enableFutureContent", false);

            builder.pop();
        }
    }
}
