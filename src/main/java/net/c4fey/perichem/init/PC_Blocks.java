package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.block.LabTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class PC_Blocks {

    public static final Block LAB_TABLE = register("lab_table", new LabTableBlock(
            AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.ANVIL).solid()
    ));

    private static Block register(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PeriodicallyChemical.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(PeriodicallyChemical.MOD_ID, name), block);
    }

    public static void initialize() {
        PeriodicallyChemical.LOGGER.info("Blocks Registered!");
    }
}
