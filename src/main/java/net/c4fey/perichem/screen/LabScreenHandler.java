package net.c4fey.perichem.screen;

import net.c4fey.perichem.init.PC_ScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class LabScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public LabScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(24));
    }

    public LabScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(PC_ScreenHandlers.LAB_SCREEN_HANDLER, syncId);
        checkSize(inventory, 24);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int x;
        int y;
        int nextId = 0;
        for (y = 0; y < 3; y++) { // Input Slots
            for (x = 0; x < 4; x++) {
                this.addSlot(new Slot(this.inventory, nextId, x * 18 + 8, y * 18 + 17));
                nextId++;
            }
        }
        for (y = 0; y < 3; y++) { // Output Slots
            for (x = 0; x < 4; x++) {
                this.addSlot(new Slot(this.inventory, nextId, x * 18 + 98, y * 18 + 17));
                nextId++;
            }
        }
        nextId = 0;
        for (x = 0; x < 9; x++) {
            this.addSlot(new Slot(playerInventory, nextId, x * 18 + 8, 142));
            nextId++;
        }
        for (y = 0; y < 3; y++) { // Inventory Slots
            for (x = 0; x < 9; x++) {
                this.addSlot(new Slot(playerInventory, nextId, x * 18 + 8, y * 18 + 84));
                nextId++;
            }
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
