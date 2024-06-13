package com.terraformersmc.terraform.boat.api;

import com.terraformersmc.terraform.boat.impl.TerraformBoatTypeImpl;
import com.terraformersmc.terraform.boat.impl.entity.TerraformBoatEntity;
import com.terraformersmc.terraform.boat.impl.entity.TerraformChestBoatEntity;
import net.minecraft.item.Item;

public interface TerraformBoatType {
    boolean isRaft();
    Item getItem();
    Item getChestItem();
    Item getPlanks();

    public static class Builder {
        private boolean raft;
        private Item item;
        private Item chestItem;
        private Item planks;

        public TerraformBoatType build() {
            return new TerraformBoatTypeImpl(this.raft, this.item, this.chestItem, this.planks);
        }
        public Builder raft() {
            this.raft = true;
            return this;
        }
        public Builder item(Item item) {
            this.item = item;
            return this;
        }

        public Builder chestItem(Item chestItem) {
            this.chestItem = chestItem;
            return this;
        }
        public Builder planks(Item planks) {
            this.planks = planks;
            return this;
        }
    }
}
