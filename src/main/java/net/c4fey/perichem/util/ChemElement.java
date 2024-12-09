package net.c4fey.perichem.util;

import java.util.ArrayList;
import java.util.List;

public class ChemElement {
    private final String symbol;
    private final ChemGroup group;
    private final int color;
    private final int storageType; // 0 = Solid, 1 = Liquid, 2 = Gas
    private final boolean hasMetalItems;

    private ChemElement(String symbol, ChemGroup group, int color, int storageType, boolean hasMetalItems) {
        this.symbol = symbol;
        this.group = group;
        this.color = color;
        this.storageType = storageType;
        this.hasMetalItems = hasMetalItems;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public ChemGroup getGroup() {
        return this.group;
    }

    public int getColor() {
        return this.color;
    }

    public int getStorageType() {
        return this.storageType;
    }

    public boolean hasMetalItems() {
        return this.hasMetalItems;
    }

    public static ArrayList<ChemElement> getChemElements() {
        ArrayList<ChemElement> elements = new ArrayList<>();

        elements.add(new ChemElement("H", ChemGroup.NONMETAL,
                0xffffffff, 2, false));
        elements.add(new ChemElement("He", ChemGroup.NOBLE_GAS,
                0xffffffff, 2, false));
        elements.add(new ChemElement("Li", ChemGroup.ALKALI,
                0xffdadada, 0, true));
        elements.add(new ChemElement("Be", ChemGroup.ALKALINE_EARTH,
                0xff434448, 0, true));
        elements.add(new ChemElement("B", ChemGroup.SEMIMETAL,
                0xff555143, 0, false));
        elements.add(new ChemElement("C", ChemGroup.NONMETAL,
                0xff000000, 0, false));
        elements.add(new ChemElement("N", ChemGroup.NONMETAL,
                0xffffffff, 2, false));
        elements.add(new ChemElement("O", ChemGroup.NONMETAL,
                0xffffffff, 2, false));
        elements.add(new ChemElement("F", ChemGroup.HALOGEN,
                0xfff9ffdd, 2, false));
        elements.add(new ChemElement("Ne", ChemGroup.NOBLE_GAS,
                0xffffffff, 2, false));
        elements.add(new ChemElement("Na", ChemGroup.ALKALI,
                0xffdadada, 0, true));
        elements.add(new ChemElement("Mg", ChemGroup.ALKALINE_EARTH,
                0xff434448, 0, true));

        return elements;
    }
}
