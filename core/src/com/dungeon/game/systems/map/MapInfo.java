package com.dungeon.game.systems.map;

import com.badlogic.gdx.math.Vector2;

public class MapInfo {

    public int stairUpMap;
    public int stairDownMap;
    public int[][] map;
    public Vector2 playerMapStartPos;

    public MapInfo (int stairUpMap, int stairDownMap, int[][] map, Vector2 playerMapStartPos) {
        this.stairUpMap = stairUpMap;
        this.stairDownMap = stairDownMap;
        this.map = map;
        this.playerMapStartPos = playerMapStartPos;
    }
}
