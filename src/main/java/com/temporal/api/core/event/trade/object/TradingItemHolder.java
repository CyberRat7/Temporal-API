package com.temporal.api.core.event.trade.object;

import net.minecraft.world.item.Item;

public class TradingItemHolder {
    private final Item item;
    private final int itemCount;

    public TradingItemHolder(Item item, int itemCount) {
        this.item = item;
        this.itemCount = itemCount;
    }

    public Item getItem() {
        return item;
    }

    public int getItemCount() {
        return itemCount;
    }
}
