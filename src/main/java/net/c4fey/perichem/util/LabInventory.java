package net.c4fey.perichem.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class LabInventory implements Inventory {
    private final DefaultedList<ItemStack> stacks = DefaultedList.ofSize(24, ItemStack.EMPTY);

    @Override
    public int size() {
        return 24;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (ItemStack stack : stacks) {
            if (!stack.equals(ItemStack.EMPTY)) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    @Override
    public ItemStack getStack(int slot) {
        return stacks.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack removed = stacks.get(slot).copyWithCount(amount);
        stacks.set(slot, stacks.get(slot).copyWithCount(stacks.get(slot).getCount() - amount));
        return removed;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack removed = stacks.get(slot).copy();
        stacks.set(slot, ItemStack.EMPTY);
        return removed;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        stacks.set(slot, stack);
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        stacks.clear();
    }
}
