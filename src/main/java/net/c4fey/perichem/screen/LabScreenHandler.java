package net.c4fey.perichem.screen;

import net.c4fey.perichem.init.PC_Recipes;
import net.c4fey.perichem.init.PC_ScreenHandlers;
import net.c4fey.perichem.recipe.LabRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

import java.util.ArrayList;

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

    private ArrayList<Item> getInputItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (!this.inventory.getStack(i).equals(ItemStack.EMPTY))
                    items.add(this.inventory.getStack(i).getItem());
        }
        return items;
    }

    private LabRecipe getMatch(ArrayList<Item> items) {
        for (LabRecipe recipe : PC_Recipes.LAB_TABLE_RECIPES) {
            if (recipe.matchInputs(items)) {
                return recipe;
            }
        }
        return null;
    }

    private boolean canTakeOutput(ArrayList<ItemStack> output) {
        return true;
    }

    private void decreaseInputs() {
        for (int i = 0; i < 12; i++) {
            this.inventory.removeStack(i, 1);
        }
    }

    private void applyOutput(ArrayList<ItemStack> output ) {
        for (ItemStack stack : output) {
            boolean stackDone = false;
            for (int i = 12; i < 24; i++) {
                if (this.inventory.getStack(i).isOf(stack.getItem())) {
                    while (this.inventory.getStack(i).getCount() <
                            this.inventory.getStack(i).getMaxCount()) {
                        this.inventory.setStack(i, this.inventory.getStack(i).copyWithCount(
                                this.inventory.getStack(i).getCount() + 1
                        ));
                        if (stack.getCount() == 1) {
                            stackDone = true;
                            break;
                        } else {
                            stack.setCount(stack.getCount() - 1);
                        }
                    }
                }
                if (this.inventory.getStack(i).equals(ItemStack.EMPTY)) {
                    this.inventory.setStack(i, stack);
                    stackDone = true;
                }
                if (stackDone) break;
            }
        }
    }

    private boolean attemptCraft() {
        ArrayList<Item> items = this.getInputItems();
        LabRecipe match = getMatch(items);
        if (match == null) return false;
        if (!canTakeOutput(match.outputs())) return false;
        this.decreaseInputs();
        this.applyOutput(match.outputs());
        return true;
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (!player.getWorld().isClient){
            boolean going;
            do {
                going = this.attemptCraft() && id == 1;
            } while (going);
        }
        return super.onButtonClick(player, id);
    }
}
