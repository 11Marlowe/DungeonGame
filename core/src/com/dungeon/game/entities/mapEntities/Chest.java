package com.dungeon.game.entities.mapEntities;

import com.dungeon.game.entities.Entity;

public class Chest extends Entity {

    public boolean isLocked;

    public Chest(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
