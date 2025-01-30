package net.ginos.funmod.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record RefinerRecipeInput(ItemStack template, ItemStack base) implements RecipeInput
{
    public RefinerRecipeInput(ItemStack template, ItemStack base) {
        this.template = template;
        this.base = base;
        //this.addition = addition;
    }

    public ItemStack getStackInSlot(int slot) {
        ItemStack var10000;
        switch (slot) {
            case 0 -> var10000 = this.template;
            case 1 -> var10000 = this.base;
            //case 2 -> var10000 = this.addition;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        }

        return var10000;
    }

    public int getSize() {
        return 2;
    }

    public boolean isEmpty() {
        return this.template.isEmpty() && this.base.isEmpty();
    }

    public ItemStack template() {
        return this.template;
    }

    public ItemStack base() {
        return this.base;
    }

    //public ItemStack addition() {
    //    return this.addition;
    //}
}
