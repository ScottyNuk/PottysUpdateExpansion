package net.potty.pupdates.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.potty.pupdates.PottysUpdates;
import net.potty.pupdates.entity.custom.ColdChickenEntity;
import net.potty.pupdates.entity.custom.WarmChickenEntity;

public class ModEntities {


    public static final EntityType<ColdChickenEntity> COLD_CHICKEN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(PottysUpdates.MOD_ID, "cold_chicken"),
            EntityType.Builder.create(ColdChickenEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.4F,0.7F)
                    .eyeHeight(0.644F)
                    .passengerAttachments(new Vec3d(0.0, 0.7, -0.1))
                    .maxTrackingRange(10)
                    .build()
    );

    public static final EntityType<WarmChickenEntity> WARM_CHICKEN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(PottysUpdates.MOD_ID, "warm_chicken"),
            EntityType.Builder.create(WarmChickenEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.4F,0.7F)
                    .eyeHeight(0.644F)
                    .passengerAttachments(new Vec3d(0.0, 0.7, -0.1))
                    .maxTrackingRange(10)
                    .build()
    );











    public static void registerModEntities(){
        PottysUpdates.LOGGER.info("Registering Mod Entities for " + PottysUpdates.MOD_ID);
    }
}
