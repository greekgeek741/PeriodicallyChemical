package net.c4fey.perichem;

import net.c4fey.perichem.init.PC_Items;
import net.c4fey.perichem.init.PC_ScreenHandlers;
import net.c4fey.perichem.item.ElementItem;
import net.c4fey.perichem.screen.LabScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class PeriodicallyChemicalClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreens.register(PC_ScreenHandlers.LAB_SCREEN_HANDLER, LabScreen::new);
		ColorProviderRegistry.ITEM.register(
				(stack, tintIndex) -> {
                    return ((ElementItem) stack.getItem()).getContentColor(tintIndex);
                },
				PC_Items.H_AMPULE,
				PC_Items.HE_AMPULE,
				PC_Items.LI_VIAL,
				PC_Items.BE_VIAL,
				PC_Items.B_VIAL,
				PC_Items.C_VIAL,
				PC_Items.N_AMPULE,
				PC_Items.O_AMPULE,
				PC_Items.F_AMPULE,
				PC_Items.NE_AMPULE,

				PC_Items.H_TANK,
				PC_Items.HE_TANK,
				PC_Items.LI_POWDER,
				PC_Items.BE_POWDER,
				PC_Items.B_POWDER,
				PC_Items.C_POWDER,
				PC_Items.N_TANK,
				PC_Items.O_TANK,
				PC_Items.F_TANK,
				PC_Items.NE_TANK);
	}
}