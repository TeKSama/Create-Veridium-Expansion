package com.tek_sama.create_veridium_expansion.content.armor;

import com.tek_sama.create_veridium_expansion.CreateVeridiumExpansion;
import com.tek_sama.create_veridium_expansion.registry.CVEItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Map;

public enum VeridiumArmorMaterial implements ArmorMaterial {
    VERIDIUM(
            "veridium",
            39, // multiplier: (netherite 37) +50% du delta diamant->netherite (=+2) => 39
            Map.of(
                    ArmorItem.Type.HELMET, 4,
                    ArmorItem.Type.CHESTPLATE, 9,
                    ArmorItem.Type.LEGGINGS, 7,
                    ArmorItem.Type.BOOTS, 4
            ),
            3.5f,   // toughness: netherite (3) + 0.5
            0.15f,  // knockback res: netherite (0.1) + 0.05
            14
    );

    // base vanilla
    private static final Map<ArmorItem.Type, Integer> BASE_DURA = Map.of(
            ArmorItem.Type.HELMET, 13,
            ArmorItem.Type.CHESTPLATE, 15,
            ArmorItem.Type.LEGGINGS, 16,
            ArmorItem.Type.BOOTS, 11
    );

    private final String nameNoNs;
    private final int mult;
    private final Map<ArmorItem.Type, Integer> defense;
    private final float toughness;
    private final float kbRes;
    private final int ench;

    VeridiumArmorMaterial(String nameNoNs, int mult, Map<ArmorItem.Type, Integer> defense,
                          float toughness, float kbRes, int ench) {
        this.nameNoNs = nameNoNs;
        this.mult = mult;
        this.defense = defense;
        this.toughness = toughness;
        this.kbRes = kbRes;
        this.ench = ench;
    }

    @Override public int getDurabilityForType(ArmorItem.Type type) { return BASE_DURA.get(type) * mult; }
    @Override public int getDefenseForType(ArmorItem.Type type) { return defense.getOrDefault(type, 0); }
    @Override public int getEnchantmentValue() { return ench; }
    @Override public net.minecraft.sounds.SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_NETHERITE; }
    @Override public Ingredient getRepairIngredient() { return Ingredient.of(CVEItems.VERIDIUM_ALLOY_PLATE.get()); }
    @Override public String getName() { return CreateVeridiumExpansion.MOD_ID + ":" + nameNoNs; }
    @Override public float getToughness() { return toughness; }
    @Override public float getKnockbackResistance() { return kbRes; }
}
