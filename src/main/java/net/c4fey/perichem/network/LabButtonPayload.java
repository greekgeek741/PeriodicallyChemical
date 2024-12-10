package net.c4fey.perichem.network;

import net.c4fey.perichem.init.PC_Networking;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

public record LabButtonPayload(int buttonId) implements CustomPayload {

    public static final CustomPayload.Id<LabButtonPayload> ID =
            new CustomPayload.Id<>(PC_Networking.LAB_PACKET_ID);
    public static final PacketCodec<RegistryByteBuf, LabButtonPayload> CODEC =
            PacketCodec.tuple(PacketCodecs.INTEGER, LabButtonPayload::buttonId, LabButtonPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
