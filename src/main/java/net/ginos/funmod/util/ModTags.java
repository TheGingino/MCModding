package net.ginos.funmod.util;


import net.ginos.funmod.FunMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_RED_FLINT_TOOL = createTag("needs_red_flint_tools");
        public static final TagKey<Block> INCORRECT_FOR_RED_FLINT_TOOL = createTag("incorrect_for_red_flint_tool");
        public static final TagKey<Block> THORK_MODDIFIER = createTag("thork_modifier");


        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FunMod.MOD_ID, name));
        }
    }
    public static class Items{
        public static TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FunMod.MOD_ID, name));
        }
    }
}
