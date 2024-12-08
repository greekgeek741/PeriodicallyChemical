package net.c4fey.perichem.screen;

import net.c4fey.perichem.init.PC_ScreenHandlers;
import net.c4fey.perichem.util.LabInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class LabScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final ScreenHandlerContext context;

    public LabScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public LabScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(PC_ScreenHandlers.LAB_SCREEN_HANDLER, syncId);
        this.inventory = new LabInventory();
        this.context = context;

        int nextIndex = 0;
        for (int y = 0; y < 3; y++) { // Lab Input Slots
            for (int x = 0; x < 4; x++) {
                this.addSlot(new Slot(inventory, nextIndex, x * 18 + 8, y * 18 + 17));
                nextIndex++;
            }
        }
        for (int y = 0; y < 3; y++) { // Lab Output Slots
            for (int x = 0; x < 4; x++) {
                this.addSlot(new Slot(inventory, nextIndex, x * 18 + 98, y * 18 + 17));
                nextIndex++;
            }
        }
        nextIndex = 0;
        for (int x = 0; x < 9; x++) { // Player Hotbar Slots
            this.addSlot(new Slot(playerInventory, nextIndex, x * 18 + 8, 142));
            nextIndex++;
        }
        for (int y = 0; y < 3; y++) { // Player Inventory Slots
            for (int x = 0; x < 9; x++) {
                this.addSlot(new Slot(playerInventory, nextIndex, x * 18 + 8, y * 18 + 84));
                nextIndex++;
            }
        }


    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> {
            this.dropInventory(player, this.inventory);
        });
    }
}
