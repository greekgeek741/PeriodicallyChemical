package net.c4fey.perichem.init;

import net.c4fey.perichem.recipe.LabRecipe;
import net.c4fey.perichem.util.ChemElement;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class PC_Recipes {
    public static final ArrayList<LabRecipe> LAB_TABLE = new ArrayList<>();

    public static void initialize() {
        for (int i = 0; i < ChemElement.getChemElements().size(); i++) {
            ArrayList<Item> list1 = new ArrayList<>();
            ArrayList<ItemStack> list2 = new ArrayList<>();
            list1.add(PC_Items.X8_STORAGE_ELEMENT_UNITS.get(i));
            list2.add(new ItemStack(PC_Items.BASIC_ELEMENT_UNITS.get(i), 8));
            LAB_TABLE.add(new LabRecipe(Blocks.AIR, list1, list2));
        }
        ArrayList<Item> list1 = new ArrayList<>();
        ArrayList<ItemStack> list2 = new ArrayList<>();
        list1.add(PC_Items.GLASS_TANK);
        for (int i = 0; i < 8; i++) {
            list1.add(PC_Items.BASIC_ELEMENT_UNITS.getFirst());
        }
        list2.add(new ItemStack(PC_Items.X8_STORAGE_ELEMENT_UNITS.getFirst()));
        list2.add(new ItemStack(PC_Items.GLASS_AMPULE_BROKEN, 8));
        LAB_TABLE.add(new LabRecipe(Blocks.AIR, list1, list2));
    }
}
