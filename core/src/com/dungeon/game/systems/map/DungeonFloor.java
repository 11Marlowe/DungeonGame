package com.dungeon.game.systems.map;

import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entities.Entity;

import java.util.List;

public class DungeonFloor {

    public MapInfo mapInfo;
    public List<Entity> mapEntity;
    private int floorNum;

    public DungeonFloor(int floorNum, MapInfo mapInfo) {
        this.mapInfo = mapInfo;
        this.floorNum = floorNum;
        initDungeonFloor();
    }

    private void initDungeonFloor() {
        // init entities based on map

        for (int x = 0; x < mapInfo.map.length; x++) {
            for (int y = 0; y < mapInfo.map[x].length; y++) {

            }
        }
    }
}
