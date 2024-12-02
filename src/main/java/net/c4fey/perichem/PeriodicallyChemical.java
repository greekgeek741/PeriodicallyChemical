package net.c4fey.perichem;

import net.c4fey.perichem.init.PC_ItemGroups;
import net.c4fey.perichem.init.PC_Items;
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
		LOGGER.info("Periodically Chemical has been initialised!");
	}
}