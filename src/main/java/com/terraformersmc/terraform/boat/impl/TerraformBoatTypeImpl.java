package com.terraformersmc.terraform.boat.impl;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import net.minecraft.item.Item;

public class TerraformBoatTypeImpl implements TerraformBoatType {
    private final boolean raft;
    private final Item item;
    private final Item chestItem;
    private final Item planks;

    public TerraformBoatTypeImpl(boolean raft, Item item, Item chestItem, Item planks) {
        this.raft = raft;
        this.item = item;
        this.chestItem = chestItem;
        this.planks = planks;
    }

    @Override
    public boolean isRaft() {
        return this.raft;
    }

    @Override
    public Item getItem() {
        return this.item;
    }

    @Override
    public Item getChestItem() {
        return this.chestItem;
    }

    @Override
    public Item getPlanks() {
        return this.planks;
    }
}
