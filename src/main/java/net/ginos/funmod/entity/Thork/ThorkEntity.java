package net.ginos.funmod.entity.Thork;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;


public class ThorkEntity extends TridentEntity {
    public ThorkEntity(EntityType<? extends ThorkEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThorkEntity(World world, LivingEntity player, ItemStack stack) {
        super(world, player, stack);
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        // Apply poison effect to hit entity
        if (entityHitResult.getEntity() instanceof LivingEntity targetEntity) {
            targetEntity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.POISON,
                    200,  // Duration (10 seconds)
                    1     // Amplifier (level of effect)
            ));
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        // Optional: Add additional effects on ground hit
        // For example, create a small poison cloud
        // AreaEffectCloudEntity could be used here
    }
}
