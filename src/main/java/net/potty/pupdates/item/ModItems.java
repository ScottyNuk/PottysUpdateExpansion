package net.potty.pupdates.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;

public class ModItems {


    //1.21.5 Items
    public static final Item RESIN_BRICK =registerItem("resin_brick", new Item(new Item.Settings()));
    public static final Item BLUE_EGG =registerItem("blue_egg", new Item(new Item.Settings()));
    public static final Item BROWN_EGG =registerItem("brown_egg", new Item(new Item.Settings()));

    public static final Item CKINGS_HEART =registerItem("ckings_heart", new Item(new Item.Settings()));






    //MODDED ITEMS
    public static final Item ARTIFACT =registerItem("artifact", new Item(new Item.Settings()));







    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PottysUpdates.MOD_ID, name), item);
    }



    public static void registerModItems() {
        PottysUpdates.LOGGER.info("Registering Mod Items for " + PottysUpdates.MOD_ID);
    }
}

