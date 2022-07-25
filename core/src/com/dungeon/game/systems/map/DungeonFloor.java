package com.dungeon.game.systems.map;

import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class DungeonFloor {

    public MapInfo mapInfo;
    public HashMap<Vector2, Entity> mapEntities;

    public DungeonFloor(MapInfo mapInfo) {
        this.mapInfo = mapInfo;
        mapEntities = new HashMap<>();
        initDungeonFloor();
    }

   protected abstract void initDungeonFloor();
}
