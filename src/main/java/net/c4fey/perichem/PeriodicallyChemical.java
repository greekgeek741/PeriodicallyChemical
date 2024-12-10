package net.c4fey.perichem;

import net.c4fey.perichem.init.*;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeriodicallyChemical implements ModInitializer {
	public static final String MOD_ID = "periodically_chemical";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PC_Items.initialize();
		PC_ItemGroups.initialize();
		PC_Blocks.initialize();
		PC_BlockEntities.initialize();
		PC_ScreenHandlers.initialize();
		PC_Networking.initialize();
		PC_Recipes.initialize();

		LOGGER.info("Periodically Chemical has been initialised!");
	}
}