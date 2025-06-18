package net.potty.pupdates.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.potty.pupdates.PottysUpdates;

public class ModSounds {


    public static final SoundEvent BLOCK_DEADBUSH_IDLE = registerSoundEvent("block.deadbush.idle");








    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(PottysUpdates.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }

    public static void registerSounds() {
        PottysUpdates.LOGGER.info("Registering Mod Sounds for " + PottysUpdates.MOD_ID);
    }
}
