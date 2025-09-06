package com.tek_sama.create_veridium_expansion.content.tools;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import com.tek_sama.create_veridium_expansion.registry.CVEItems;

@net.minecraft.MethodsReturnNonnullByDefault
@javax.annotation.ParametersAreNonnullByDefault
public enum VeridiumToolMaterial implements Tier {
    // lvl 4 (comme netherite), 2266 uses (+50% delta), speed 9.0F (netherite),
    // ATTENTION: +0.5F d’attaque pour appliquer le +50% dmg à TOUTES les tools
    VERIDIUM(4, 2266, 9.0F, 4.5F, 15);

    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus; // << 4.5F (netherite ~4.0F)
    private final int enchantability;

    VeridiumToolMaterial(int level, int uses, float speed, float attackDamageBonus, int enchantability) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantability = enchantability;
    }

    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return attackDamageBonus; }
    @Override public int getLevel() { return level; }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public Ingredient getRepairIngredient() {
        return Ingredient.of(CVEItems.VERIDIUM_ALLOY_PLATE.get());
    }
}
