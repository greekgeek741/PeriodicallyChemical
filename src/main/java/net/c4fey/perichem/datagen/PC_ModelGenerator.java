package net.c4fey.perichem.datagen;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.init.PC_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
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
        itemModelGenerator.register(PC_Items.H_AMPULE, item("gas_ampule"));
        itemModelGenerator.register(PC_Items.HE_AMPULE, item("gas_ampule"));
        itemModelGenerator.register(PC_Items.LI_VIAL, item("powder_vial"));
        itemModelGenerator.register(PC_Items.BE_VIAL, item("powder_vial"));
        itemModelGenerator.register(PC_Items.B_VIAL, item("powder_vial"));
        itemModelGenerator.register(PC_Items.C_VIAL, item("powder_vial"));
        itemModelGenerator.register(PC_Items.N_AMPULE, item("gas_ampule"));
        itemModelGenerator.register(PC_Items.O_AMPULE, item("gas_ampule"));
        itemModelGenerator.register(PC_Items.F_AMPULE, item("gas_ampule"));
        itemModelGenerator.register(PC_Items.NE_AMPULE, item("gas_ampule"));
    }

    public static Model item(String parent) {
        return new Model(Optional.of(
                Identifier.of(PeriodicallyChemical.MOD_ID, "item/" + parent)), Optional.empty());
    }
}
