package com.tek_sama.create_veridium_expansion.content.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;

public class ODSTRecordItem extends RecordItem {

    public ODSTRecordItem(SoundEvent sound, Item.Properties props) {
        super(
                15,                  // comparator output
                sound,               // ton SoundEvent
                props.stacksTo(1).rarity(Rarity.RARE),
                20 * 177             // durée en ticks (≈ 2min57)
        );
    }
}
