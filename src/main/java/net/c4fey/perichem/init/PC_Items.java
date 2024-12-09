package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.item.ElementItem;
import net.c4fey.perichem.util.ChemElement;
import net.c4fey.perichem.util.ChemGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class PC_Items {

    public static final Item GLASS_AMPULE = register(new Item(new Item.Settings()), "glass_ampule");
    public static final Item GLASS_AMPULE_BROKEN = register(new Item(new Item.Settings()),
            "glass_ampule_broken");
    public static final Item GLASS_VIAL = register(new Item(new Item.Settings()), "glass_vial");
    public static final Item GLASS_TANK = register(new Item(new Item.Settings()), "glass_tank");
    public static final Item GLASS_JUG = register(new Item(new Item.Settings()), "glass_jug");

    public static final ArrayList<ElementItem> BASIC_ELEMENT_UNITS = new ArrayList<>();
    public static final ArrayList<ElementItem> X8_STORAGE_ELEMENT_UNITS = new ArrayList<>();
    public static final ArrayList<ElementItem> METAL_ELEMENT_INGOTS = new ArrayList<>();

    private static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Identifier.of(PeriodicallyChemical.MOD_ID, id), item);
    }

    public static void initialize() {
        for (ChemElement element : ChemElement.getChemElements()) {

            String basicItemType = element.getStorageType() == 0 ? "vial" : "ampule";
            BASIC_ELEMENT_UNITS.add((ElementItem) register(new ElementItem(
                    new Item.Settings(), element, basicItemType),
                    element.getSymbol().toLowerCase() + "_" + basicItemType));

            String x8ItemType = switch (element.getStorageType()) {
                case 0 -> "powder";
                case 1 -> "jug";
                default -> "tank";
            };
            X8_STORAGE_ELEMENT_UNITS.add((ElementItem) register(new ElementItem(
                    new Item.Settings(), element, x8ItemType),
                    element.getSymbol().toLowerCase() + "_" + x8ItemType));

            if (element.hasMetalItems()) {
                METAL_ELEMENT_INGOTS.add((ElementItem) register(new ElementItem(
                        new Item.Settings(), element, "ingot"),
                        element.getSymbol().toLowerCase() + "_ingot"));
            }
        }

        PeriodicallyChemical.LOGGER.info("Items Registered!");
    }
}
