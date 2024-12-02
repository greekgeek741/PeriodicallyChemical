package net.c4fey.perichem.util;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public enum ChemGroup {
    NONMETAL, NOBLE_GAS, ALKALI,
    ALKALINE_EARTH, SEMIMETAL, HALOGEN,
    TRANSITION, POST_TRANSITION,
    LANTHANIDE, ACTINIDE;

    public Text getName() {
        return switch (this) {
            case NONMETAL -> Text.translatable("chemgroup.nonmetal");
            case NOBLE_GAS -> Text.translatable("chemgroup.noble_gas");
            case ALKALI -> Text.translatable("chemgroup.alkali");
            case ALKALINE_EARTH -> Text.translatable("chemgroup.alkaline_earth");
            case SEMIMETAL -> Text.translatable("chemgroup.semimetal");
            case HALOGEN -> Text.translatable("chemgroup.halogen");
            case TRANSITION -> Text.translatable("chemgroup.transition");
            case POST_TRANSITION -> Text.translatable("chemgroup.post_transition");
            case LANTHANIDE -> Text.translatable("chemgroup.lanthanide");
            case ACTINIDE -> Text.translatable("chemgroup.actinide");
        };
    }

    public boolean isMetal() {
        return switch (this) {
            case NONMETAL, NOBLE_GAS, SEMIMETAL, HALOGEN -> false;
            default -> true;
        };
    }

    public Formatting getColor() {
        return switch (this) {
            case NONMETAL -> Formatting.BLUE;
            case NOBLE_GAS -> Formatting.DARK_BLUE;
            case ALKALI -> Formatting.AQUA;
            case ALKALINE_EARTH -> Formatting.DARK_AQUA;
            case SEMIMETAL -> Formatting.RED;
            case HALOGEN -> Formatting.GREEN;
            case TRANSITION -> Formatting.YELLOW;
            case POST_TRANSITION -> Formatting.GOLD;
            case LANTHANIDE -> Formatting.LIGHT_PURPLE;
            case ACTINIDE -> Formatting.DARK_PURPLE;
        };
    }

    public Text getColoredName() {
        return this.getName().copy().formatted(this.getColor());
    }
}
