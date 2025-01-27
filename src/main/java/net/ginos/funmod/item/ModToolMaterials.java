package net.ginos.funmod.item;

import com.google.common.base.Suppliers;
import net.ginos.funmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    RED_FLINT(ModTags.Blocks.INCORRECT_FOR_RED_FLINT_TOOL,
            1200, 6.0F, 2.0F, 22, () -> Ingredient.ofItems(new ItemConvertible[]{ModItems.RED_FLINT})),
    RED_FLINT_ARMOR(ModTags.Blocks.INCORRECT_FOR_RED_FLINT_TOOL,
            1200, 6.0F, 2.0F, 22, () -> Ingredient.ofItems(new ItemConvertible[]{ModItems.RED_FLINT})),

    SUPER_CRUSHER(ModTags.Blocks.INCORRECT_FOR_RED_FLINT_TOOL,
            320, 8.0F, 2.0F, 0, () -> Ingredient.ofItems(new ItemConvertible[]{Items.NETHER_STAR})),
    THORK(ModTags.Blocks.THORK_MODDIFIER,
            600,6,8,18, () -> Ingredient.ofItems(new ItemConvertible[]{ModItems.THORK})),
    ;




    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed,
            final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
