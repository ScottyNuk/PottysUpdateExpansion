package net.potty.pupdates.util;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModWorldUtil {

    // Check if it's night and the world is "natural" (e.g., Overworld)
    public static boolean isNightAndNatural(World world) {
        if (!world.getDimension().natural()) {
            return false;
        }
        long time = world.getTimeOfDay() % 24000L;
        return time >= 12600 && time <= 23400;
    }

    // Play sound at center of block (for client)
    public static void playSoundAtBlockCenterClient(World world, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch, boolean useDistance) {
        // Only play on client side
        if (!world.isClient) return;

        double x = pos.getX() + 0.5;
        double y = pos.getY() + 0.5;
        double z = pos.getZ() + 0.5;

        world.playSound(x, y, z, sound, category, volume, pitch, useDistance);
    }
}
