package net.ginos.funmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record DrowningFeelEnchantment() implements EnchantmentEntityEffect {
    public static final MapCodec<DrowningFeelEnchantment> CODEC = MapCodec.unit(DrowningFeelEnchantment::new);


    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1){
            EntityType.WIND_CHARGE.spawn(world,user.getBlockPos(), SpawnReason.TRIGGERED);
        }
        if (level == 2){

            EntityType.DRAGON_FIREBALL.spawn(world,user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.DRAGON_FIREBALL.spawn(world,user.getBlockPos(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
