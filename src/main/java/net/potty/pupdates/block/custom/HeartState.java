package net.potty.pupdates.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum HeartState implements StringIdentifiable {
    OFF("off"),
    DORMANT("dormant"),
    ON("on");

    private final String name;

    HeartState(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return name;
    }
}
