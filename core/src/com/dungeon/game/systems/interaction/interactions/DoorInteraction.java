package com.dungeon.game.systems.interaction.interactions;

import com.dungeon.game.entities.mapEntities.Door;
import com.dungeon.game.systems.interaction.Interaction;

public class DoorInteraction implements Interaction {

    private final Door door;

    public DoorInteraction(final Door door) {

        this.door = door;
    }

    @Override
    public String getTextForInteraction() {
        if (door.isLocked) {
            return "The door is locked.";
        }
        return "You have a key, will you try it?";
    }

    // todo: this will probably need to return a choice class
    // need some way to define choices
    @Override
    public String getChoicesForInteraction() {
        return null;
    }
}
