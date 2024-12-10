package net.c4fey.perichem.init;

import net.c4fey.perichem.recipe.LabRecipe;
import net.c4fey.perichem.util.ChemElement;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class PC_Recipes {
    public static final ArrayList<LabRecipe> LAB_TABLE_RECIPES = new ArrayList<>();

    public static void initialize() {
        for (int i = 0; i < ChemElement.getChemElements().size(); i++) {
            ArrayList<Item> list1 = new ArrayList<>();
            ArrayList<ItemStack> list2 = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                list1.add(PC_Items.BASIC_ELEMENT_UNITS.get(i));
            }
            list2.add(new ItemStack(PC_Items.X8_STORAGE_ELEMENT_UNITS.get(i)));
            switch (ChemElement.getChemElements().get(i).getStorageType()) {
                case 0 -> list2.add(new ItemStack(PC_Items.GLASS_VIAL, 8));
                case 1 -> {
                    list2.add(new ItemStack(PC_Items.GLASS_AMPULE_BROKEN, 8));
                    list1.add(PC_Items.GLASS_JUG);
                }
                default -> {
                    list2.add(new ItemStack(PC_Items.GLASS_AMPULE_BROKEN, 8));
                    list1.add(PC_Items.GLASS_TANK);
                }
            }
            LAB_TABLE_RECIPES.add(new LabRecipe(list1, list2));
        }
        for (int i = 0; i < ChemElement.getChemElements().size(); i++) {
            ArrayList<Item> list1 = new ArrayList<>();
            ArrayList<ItemStack> list2 = new ArrayList<>();
            list1.add(PC_Items.X8_STORAGE_ELEMENT_UNITS.get(i));
            list2.add(new ItemStack(PC_Items.BASIC_ELEMENT_UNITS.get(i), 8));
            switch (ChemElement.getChemElements().get(i).getStorageType()) {
                case 0 -> {
                    for (int j = 0; j < 8; j++) {
                        list1.add(PC_Items.GLASS_VIAL);
                    }
                }
                case 1 -> {
                    for (int j = 0; j < 8; j++) {
                        list1.add(PC_Items.GLASS_AMPULE);
                    }
                    list2.add(new ItemStack(PC_Items.GLASS_JUG));
                }
                default -> {
                    for (int j = 0; j < 8; j++) {
                        list1.add(PC_Items.GLASS_AMPULE);
                    }
                    list2.add(new ItemStack(PC_Items.GLASS_TANK));
                }
            }
            LAB_TABLE_RECIPES.add(new LabRecipe(list1, list2));
        }
    }
}
