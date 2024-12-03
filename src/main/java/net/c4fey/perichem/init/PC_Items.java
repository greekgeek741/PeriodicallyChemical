package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.item.ElementItem;
import net.c4fey.perichem.util.ChemGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PC_Items {

    public static final Item GLASS_AMPULE = register(new Item(new Item.Settings()), "glass_ampule");
    public static final Item GLASS_AMPULE_BROKEN = register(new Item(new Item.Settings()),
            "glass_ampule_broken");
    public static final Item GLASS_VIAL = register(new Item(new Item.Settings()), "glass_vial");

    public static final Item H_AMPULE = register(new ElementItem(new Item.Settings(),
            "H", ChemGroup.NONMETAL, 0xffffffff), "h_ampule");
    public static final Item HE_AMPULE = register(new ElementItem(new Item.Settings(),
            "He", ChemGroup.NOBLE_GAS, 0xffffffff), "he_ampule");
    public static final Item LI_VIAL = register(new ElementItem(new Item.Settings(),
            "Li", ChemGroup.ALKALI, 0xffdadada), "li_vial");
    public static final Item BE_VIAL = register(new ElementItem(new Item.Settings(),
            "Be", ChemGroup.ALKALINE_EARTH, 0xff434448), "be_vial");
    public static final Item B_VIAL = register(new ElementItem(new Item.Settings(),
            "B", ChemGroup.SEMIMETAL, 0xff555143), "b_vial");
    public static final Item C_VIAL = register(new ElementItem(new Item.Settings(),
            "C", ChemGroup.NONMETAL, 0xff000000), "c_vial");
    public static final Item N_AMPULE = register(new ElementItem(new Item.Settings(),
            "N", ChemGroup.NONMETAL, 0xffffffff), "n_ampule");
    public static final Item O_AMPULE = register(new ElementItem(new Item.Settings(),
            "O", ChemGroup.NONMETAL, 0xffffffff), "o_ampule");
    public static final Item F_AMPULE = register(new ElementItem(new Item.Settings(),
            "F", ChemGroup.HALOGEN, 0xffdcffcc), "f_ampule");
    public static final Item NE_AMPULE = register(new ElementItem(new Item.Settings(),
            "Ne", ChemGroup.NOBLE_GAS, 0xffffffff), "ne_ampule");

    private static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Identifier.of(PeriodicallyChemical.MOD_ID, id), item);
    }

    public static void initialize() {
        PeriodicallyChemical.LOGGER.info("Items Registered!");
    }
}
