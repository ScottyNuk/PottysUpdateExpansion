package net.potty.pupdates.block;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ModBlock {

    public static VoxelShape createColumnShape(double sizeXz, double minY, double maxY) {
        return createColumnShape(sizeXz, sizeXz, minY, maxY);
    }

    public static VoxelShape createColumnShape(double sizeX, double sizeZ, double minY, double maxY) {
        double d = sizeX / 2.0;
        double e = sizeZ / 2.0;
        return VoxelShapes.cuboid(
                (8.0 - d) / 16.0,
                minY / 16.0,
                (8.0 - e) / 16.0,
                (8.0 + d) / 16.0,
                maxY / 16.0,
                (8.0 + e) / 16.0
        );
    }

    public static VoxelShape createCuboidShape(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return VoxelShapes.cuboid(minX / 16.0, minY / 16.0, minZ / 16.0, maxX / 16.0, maxY / 16.0, maxZ / 16.0);
    }

    public static VoxelShape createCuboidZShape(double sizeX, double minY, double maxY, double minZ, double maxZ) {
        double d = sizeX / 2.0;
        return createCuboidShape(8.0 - d, minY, minZ, 8.0 + d, maxY, maxZ);
    }
}
