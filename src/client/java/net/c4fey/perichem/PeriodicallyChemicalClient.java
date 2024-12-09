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
		registerColorProviders();
	}

	private void registerColorProviders() {
		for (ElementItem item : PC_Items.BASIC_ELEMENT_UNITS) {
			ColorProviderRegistry.ITEM.register(
					(stack, tintIndex) -> {
						return ((ElementItem) stack.getItem()).getContentColor(tintIndex);
					},
					item
			);
		}
		for (ElementItem item : PC_Items.X8_STORAGE_ELEMENT_UNITS) {
			ColorProviderRegistry.ITEM.register(
					(stack, tintIndex) -> {
						return ((ElementItem) stack.getItem()).getContentColor(tintIndex);
					},
					item
			);
		}
	}
}