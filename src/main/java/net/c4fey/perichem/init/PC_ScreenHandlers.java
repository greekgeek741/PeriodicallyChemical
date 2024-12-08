package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.screen.LabScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class PC_ScreenHandlers {
    public static final ScreenHandlerType<LabScreenHandler> LAB_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,
                    Identifier.of(PeriodicallyChemical.MOD_ID, "lab"),
                    new ScreenHandlerType<>(LabScreenHandler::new, FeatureSet.empty()));

    public static void initialize() {
        PeriodicallyChemical.LOGGER.info("Screen Handlers registered!");
    }
}
