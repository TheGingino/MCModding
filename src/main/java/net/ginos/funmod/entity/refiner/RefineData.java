package net.ginos.funmod.entity.refiner;

import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.math.BlockPos;

public record RefineData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, RefineData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, RefineData::pos, RefineData::new);
}
