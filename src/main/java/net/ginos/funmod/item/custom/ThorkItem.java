package net.ginos.funmod.item.custom;

import net.ginos.funmod.entity.Thork.ThorkEntity;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ThorkItem extends TridentItem {

    EntityType<? extends ThorkEntity> type;
    public ThorkItem(Item.Settings settings,EntityType<? extends ThorkEntity> entityType) {
        super(settings);
        this.type = entityType;
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID,
                (double)8.0F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, (double)-2.9F, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND).build();
    }
    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            if (!world.isClient) {
                stack.damage(1, playerEntity, LivingEntity.getSlotForHand(user.getActiveHand()));
                ProjectileEntity tridentEntity = createEntity(world, user, stack);
                tridentEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F); // Adjust velocity as needed
                world.spawnEntity(tridentEntity);

            }
        }

        //super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }
    public ProjectileEntity createEntity(World world, LivingEntity user, ItemStack stack) {
        ThorkEntity thorkEntity = new ThorkEntity(world,user, stack.copyAndEmpty());
        thorkEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        thorkEntity.setOwner(user);
        return thorkEntity;
    }
}
