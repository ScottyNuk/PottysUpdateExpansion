package net.potty.pupdates.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.screen.custom.UpdateAltarScreenHandler;

public class ModScreenHandlers {

    public static ScreenHandlerType<UpdateAltarScreenHandler> UPDATE_ALTAR;

    public static void registerScreenHandlers() {
        PottysUpdates.LOGGER.info("Registering Screen Handlers for " + PottysUpdates.MOD_ID);

        UPDATE_ALTAR = Registry.register(
                Registries.SCREEN_HANDLER,
                Identifier.of(PottysUpdates.MOD_ID, "update_altar"),
                new ScreenHandlerType<>(UpdateAltarScreenHandler::new, FeatureSet.empty())
        );
    }
}
