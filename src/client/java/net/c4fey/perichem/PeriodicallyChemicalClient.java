package net.c4fey.perichem;

import net.c4fey.perichem.init.PC_Items;
import net.c4fey.perichem.item.ElementItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class PeriodicallyChemicalClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
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
				PC_Items.NE_AMPULE);
	}
}