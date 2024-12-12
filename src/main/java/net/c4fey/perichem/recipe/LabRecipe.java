package net.c4fey.perichem.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public record LabRecipe(Identifier id, ArrayList<Item> inputs, ArrayList<ItemStack> outputs) {

    public boolean matchInputs(ArrayList<Item> items) {
        boolean found = false;
        for (Item input : this.inputs) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(input)) {
                    items.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

}
