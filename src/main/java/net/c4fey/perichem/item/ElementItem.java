package net.c4fey.perichem.item;

import net.c4fey.perichem.util.ChemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;

import java.util.List;

public class ElementItem extends Item {
    private final int contentColor;
    private final String symbol;
    private final ChemGroup chemGroup;

    public ElementItem(Settings settings, String symbol, ChemGroup chemGroup, int contentColor) {
        super(settings);
        this.symbol = symbol;
        this.chemGroup = chemGroup;
        this.contentColor = contentColor;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.of(this.symbol).copy().formatted(this.chemGroup.getColor()));
        tooltip.add(this.chemGroup.getColoredName());
    }

    public int getContentColor(int tintIndex) {
        return tintIndex == 0 ? contentColor: -1;
    }
}
