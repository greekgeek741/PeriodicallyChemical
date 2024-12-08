package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.block.entity.LabTableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PC_BlockEntities {
    public static final BlockEntityType<LabTableBlockEntity> LAB_TABLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of(PeriodicallyChemical.MOD_ID, "lab_table_be"),
                    BlockEntityType.Builder.create(LabTableBlockEntity::new,
                            PC_Blocks.LAB_TABLE).build());

    public static void initialize() {
        PeriodicallyChemical.LOGGER.info("Block Entity Types registered!");
    }
}
