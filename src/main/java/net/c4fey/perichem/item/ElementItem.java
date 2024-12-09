package net.c4fey.perichem.item;

import net.c4fey.perichem.util.ChemElement;
import net.c4fey.perichem.util.ChemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class ElementItem extends Item {
    private final ChemElement element;
    private final String itemType;

    public ElementItem(Settings settings, ChemElement element, String itemType) {
        super(settings);
        this.element = element;
        this.itemType = itemType;
    }

    public ChemElement getElement() {
        return this.element;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.of(this.element.getSymbol()).copy().formatted(this.element.getGroup().getColor()));
        tooltip.add(this.element.getGroup().getColoredName());
    }

    public int getContentColor(int tintIndex) {
        return tintIndex == 0 ? this.element.getColor(): -1;
    }

    @Override
    public Text getName() {
        return Text.translatable("element.periodically_chemical." + this.element.getSymbol().toLowerCase())
                .append(" ").append(Text.translatable("itemtype.periodically_chemical." + this.itemType));
    }

    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
