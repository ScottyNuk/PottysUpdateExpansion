package net.potty.pupdates.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> DRY_VEGETATION_MAY_PLACE_ON = createTag("dry_vegetation_may_place_on");
        public static final TagKey<Block> PLAYS_AMBIENT_DESERT_BLOCK_SOUNDS = createTag("plays_ambient_desert_block_sounds");




        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PottysUpdates.MOD_ID, name));

        }

    }

    public static class Items {





        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PottysUpdates.MOD_ID, name));

        }

    }
}
