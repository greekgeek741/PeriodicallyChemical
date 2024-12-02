package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PC_ItemGroups {
    public static final RegistryKey<ItemGroup> CHEM_TOOLS_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(), Identifier.of(PeriodicallyChemical.MOD_ID, "chem_tools_group"));
    public static final ItemGroup CHEM_TOOLS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PC_Items.GLASS_AMPULE))
            .displayName(Text.translatable("itemgroup.chemistry_tools")).build();
    public static final RegistryKey<ItemGroup> ELEMENTS_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(), Identifier.of(PeriodicallyChemical.MOD_ID, "elements_group"));
    public static final ItemGroup ELEMENTS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PC_Items.GLASS_AMPULE))
            .displayName(Text.translatable("itemgroup.elements")).build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CHEM_TOOLS_GROUP_KEY, CHEM_TOOLS_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CHEM_TOOLS_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(PC_Items.GLASS_AMPULE);
            itemGroup.add(PC_Items.GLASS_VIAL);
        });
        Registry.register(Registries.ITEM_GROUP, ELEMENTS_GROUP_KEY, ELEMENTS_GROUP);
        ItemGroupEvents.modifyEntriesEvent(ELEMENTS_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(PC_Items.H_AMPULE);
            itemGroup.add(PC_Items.HE_AMPULE);
            itemGroup.add(PC_Items.LI_VIAL);
            itemGroup.add(PC_Items.BE_VIAL);
            itemGroup.add(PC_Items.B_VIAL);
            itemGroup.add(PC_Items.C_VIAL);
            itemGroup.add(PC_Items.N_AMPULE);
            itemGroup.add(PC_Items.O_AMPULE);
            itemGroup.add(PC_Items.F_AMPULE);
            itemGroup.add(PC_Items.NE_AMPULE);
        });
    }
}