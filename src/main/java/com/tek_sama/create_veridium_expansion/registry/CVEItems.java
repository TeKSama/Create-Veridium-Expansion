package com.tek_sama.create_veridium_expansion.registry;

// Mod imports
import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import com.tek_sama.create_veridium_expansion.content.armor.VeridiumArmorItem;
import com.tek_sama.create_veridium_expansion.content.armor.VeridiumArmorMaterial;
import com.tek_sama.create_veridium_expansion.content.backtank.VeridiumBacktankItem;
import com.tek_sama.create_veridium_expansion.content.tools.VeridiumToolMaterial;
import com.tek_sama.create_veridium_expansion.content.armor.VeridiumDivingHelmetItem;
import com.tek_sama.create_veridium_expansion.content.armor.VeridiumDivingBootsItem;




// Minecraft imports
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

// Forge imports
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CVEItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateVeridiumExpansion.MOD_ID);

    // ====== Items de base ======
    public static final RegistryObject<Item> VERIDIUM_ALLOY_PLATE_RAW =
            ITEMS.register("veridium_alloy_plate_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_ALLOY_PLATE =
            ITEMS.register("veridium_alloy_plate", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_SMITHING_TEMPLATE =
            ITEMS.register("veridium_smithing_template", () -> new Item(new Item.Properties()));

    // ====== Armure Veridium ======
    public static final RegistryObject<Item> VERIDIUM_HELMET =
            ITEMS.register("veridium_helmet",
                    () -> new VeridiumArmorItem(VeridiumArmorMaterial.VERIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_CHESTPLATE =
            ITEMS.register("veridium_chestplate",
                    () -> new VeridiumArmorItem(VeridiumArmorMaterial.VERIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_LEGGINGS =
            ITEMS.register("veridium_leggings",
                    () -> new VeridiumArmorItem(VeridiumArmorMaterial.VERIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_BOOTS =
            ITEMS.register("veridium_boots",
                    () -> new VeridiumArmorItem(VeridiumArmorMaterial.VERIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    // ====== Veridium Diving Armor ======
    public static final RegistryObject<Item> VERIDIUM_DIVING_HELMET =
            ITEMS.register("veridium_diving_helmet",
                    () -> new VeridiumDivingHelmetItem(VeridiumArmorMaterial.VERIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_BACKTANK =
            ITEMS.register("veridium_backtank",
                    () -> new VeridiumBacktankItem(VeridiumArmorMaterial.VERIDIUM,
                            new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VERIDIUM_DIVING_BOOTS =
            ITEMS.register("veridium_diving_boots",
                    () -> new VeridiumDivingBootsItem(VeridiumArmorMaterial.VERIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));





    // ====== Disque ODST ======
    public static final RegistryObject<Item> MUSIC_DISC_ODST =
            ITEMS.register("music_disc_odst", () ->
                    new com.tek_sama.create_veridium_expansion.content.items.ODSTRecordItem(
                            CVESounds.MUSIC_DISC_ODST.get(),
                            new Item.Properties()
                    ));


    // ====== Outils Veridium ======
    public static final RegistryObject<Item> VERIDIUM_SWORD =
            ITEMS.register("veridium_sword",
                    () -> new SwordItem(VeridiumToolMaterial.VERIDIUM, 3, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_PICKAXE =
            ITEMS.register("veridium_pickaxe",
                    () -> new PickaxeItem(VeridiumToolMaterial.VERIDIUM, 1, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_AXE =
            ITEMS.register("veridium_axe",
                    () -> new AxeItem(VeridiumToolMaterial.VERIDIUM, 5.0F, -3.0F, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_SHOVEL =
            ITEMS.register("veridium_shovel",
                    () -> new ShovelItem(VeridiumToolMaterial.VERIDIUM, 1.5F, -3.0F, new Item.Properties()));

    public static final RegistryObject<Item> VERIDIUM_HOE =
            ITEMS.register("veridium_hoe",
                    () -> new HoeItem(VeridiumToolMaterial.VERIDIUM, -4, 0.0F, new Item.Properties()));
}
