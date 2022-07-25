package com.dungeon.game.entities.mapEntities;

import com.dungeon.game.entities.Entity;

public class Door extends Entity {

    public boolean isLocked;

    public Door(boolean isLocked) {
        this.isLocked = isLocked;
    }

}
