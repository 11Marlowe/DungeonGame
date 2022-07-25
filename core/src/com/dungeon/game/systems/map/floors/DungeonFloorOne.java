package com.dungeon.game.systems.map.floors;

import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entities.mapEntities.Door;
import com.dungeon.game.systems.map.DungeonFloor;
import com.dungeon.game.systems.map.MapInfo;

public class DungeonFloorOne extends DungeonFloor {

    public DungeonFloorOne(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    protected void initDungeonFloor() {
        this.mapEntities.put(new Vector2(7, 0), new Door(true));
    }
}
