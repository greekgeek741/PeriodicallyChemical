package net.c4fey.perichem;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeriodicallyChemical implements ModInitializer {
	public static final String MOD_ID = "periodically_chemical";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Periodically Chemical has been initialised!");
	}
}