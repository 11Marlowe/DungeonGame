package com.dungeon.game.systems.interaction;

public class Interaction {

    public enum Type {
        NONE,
        LOCKED_DOOR
    }

    public static final int interactionID = 120;

    public Type type;
    public int interactionUIId;

    public Interaction(Type type) {
        this.type = type;
        interactionUIId = 0;
    }
}
