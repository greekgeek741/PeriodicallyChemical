package net.c4fey.perichem.datagen;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.init.PC_Items;
import net.c4fey.perichem.item.ElementItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PC_ModelGenerator extends FabricModelProvider {
    public PC_ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (ElementItem item : PC_Items.BASIC_ELEMENT_UNITS) {
            String parent = switch (item.getElement().getStorageType()) {
                case 0 -> "powder_vial";
                case 1 -> "liquid_ampule";
                default -> "gas_ampule";
            };
            itemModelGenerator.register(item, item(parent));
        }
        for (ElementItem item : PC_Items.X8_STORAGE_ELEMENT_UNITS) {
            String parent = switch (item.getElement().getStorageType()) {
                case 0 -> "powder";
                case 1 -> "liquid_jug";
                default -> "gas_tank";
            };
            itemModelGenerator.register(item, item(parent));
        }
    }

    public static Model item(String parent) {
        return new Model(Optional.of(
                Identifier.of(PeriodicallyChemical.MOD_ID, "item/" + parent)), Optional.empty());
    }
}
