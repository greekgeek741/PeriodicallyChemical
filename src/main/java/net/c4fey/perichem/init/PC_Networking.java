package net.c4fey.perichem.init;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.network.LabButtonPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class PC_Networking {

    public static final Identifier LAB_PACKET_ID =
            Identifier.of(PeriodicallyChemical.MOD_ID, "lab_packet");

    public static void initialize() {
        PayloadTypeRegistry.playC2S().register(LabButtonPayload.ID, LabButtonPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(LabButtonPayload.ID, (payload, context) -> {
            context.player().currentScreenHandler.onButtonClick(context.player(), payload.buttonId());
        });

    }
}
