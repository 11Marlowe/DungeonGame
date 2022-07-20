package com.dungeon.game.systems.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.TestGameScreen;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.events.Event;
import com.dungeon.game.systems.events.EventArgs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

public class MapSystem {

    public enum Tiles {
        FLOOR(0),
        WALL(1),
        STAIRS_UP(4),
        STAIRS_DOWN(3),
        DOOR(5);

        private final int value;

        Tiles(final int value) {
            this.value = value;
        }

        public static Optional<Tiles> valueOf(int value) {
            return Arrays.stream(values())
                    .filter(tiles -> tiles.value == value)
                    .findFirst();
        }

    }

    public Event playerCanMove;

    public Event interactionFound;

    private DungeonFloor currentDungeonFloor;
    private final Texture wall;
    private final Texture floor;
    private final Texture stairDown;
    private final Texture stairUp;
    private final Texture door;
    private HashMap<Integer, DungeonFloor> dungeonFloors;
    private HashMap<Player.Direction, Vector2> moveDirIncrements;
    private HashMap<Tiles, Texture> tiles;

    public static final int TILE_SIZE = 32;

    public MapSystem() {
        wall = new Texture(Gdx.files.internal("wall.png"));
        floor = new Texture(Gdx.files.internal("floor.png"));
        stairDown = new Texture(Gdx.files.internal("stair.png"));
        stairUp  = new Texture(Gdx.files.internal("stairup.png"));
        door = new Texture(Gdx.files.internal("door.png"));
        interactionFound = new Event();
        playerCanMove = new Event();
        createLookupTables();

        initMaps();
    }

    public void renderMap(SpriteBatch batch) {
        int[][] map  = currentDungeonFloor.mapInfo.map;

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                // always draw floor in case tile has transparency
                batch.draw(floor, y * TILE_SIZE, x * TILE_SIZE);
                if (map[x][y] == 0) {
                    continue;
                }

                Tiles tile = Tiles.valueOf(map[x][y]).get();
                batch.draw(tiles.get(tile), y * TILE_SIZE, x * TILE_SIZE);
            }
        }
    }

    public Consumer<EventArgs> checkMapForInteraction = args -> {
        Player player = TestGameScreen.getPlayer();
        Vector2 vec = moveDirIncrements.get(player.direction);
        int x = (int)(player.pos.x / 32 + vec.x);
        int y = (int)(player.pos.y / 32 + vec.y);

        // check player dir and pos, also change to use tile enum
        if (currentDungeonFloor.mapInfo.map[y][x] == 5) {
            interactionFound.broadcast(new EventArgs(5));
        }
    };

    public Consumer<EventArgs> checkPlayerMapPosForMove = args -> {
        Player player = TestGameScreen.getPlayer();
        Player.Direction direction = (Player.Direction)args.args;
        Vector2 vec = moveDirIncrements.get(direction);
        boolean canMove = checkMove((int) (player.pos.x/32 + vec.x), (int) (player.pos.y/32 + vec.y));
        boolean onStairs = checkForStairs((int) (player.pos.x/32 + vec.x), (int) (player.pos.y/32 + vec.y));
        // if the player can move and will be on stairs just put player in the next map, no need to move
        if (canMove && onStairs) {
            player.pos = new Vector2(currentDungeonFloor.mapInfo.playerMapStartPos.x, currentDungeonFloor.mapInfo.playerMapStartPos.y);
        } else if (canMove) {
            playerCanMove.broadcast(new EventArgs(direction));
        }
    };

    private boolean checkMove(int x, int y) {
        int[][] map  = currentDungeonFloor.mapInfo.map;
        return map[y][x] == 0
                || map[y][x] == 3
                || map[y][x] == 4;
    }

    private boolean checkForStairs(int x, int y) {
        MapInfo mapInfo  = currentDungeonFloor.mapInfo;

        if (mapInfo.map[y][x] == 3) {
            currentDungeonFloor = dungeonFloors.get(mapInfo.stairDownMap);
            return true;
        } else if (mapInfo.map[y][x] == 4) {
            currentDungeonFloor = dungeonFloors.get(mapInfo.stairUpMap);
            return true;
        } else {
            return false;
        }
    }

    private void initMaps() {
        dungeonFloors = new HashMap<>();
        dungeonFloors.put(1, new DungeonFloor(1, new MapInfo(0, 2, new int[][] {
                {1, 1, 1, 1, 1, 1, 1, 5, 1, 1},
                {1, 4, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 3, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        }, new Vector2(32, 32))));
        dungeonFloors.put(2, new DungeonFloor(2, new MapInfo(1, 3, new int[][] {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 4, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                {1, 3, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        }, new Vector2(32, 32))));
        currentDungeonFloor = dungeonFloors.get(1);
    }

    // method used to avoid lots of if statements
    private void createLookupTables() {
        // lookup for player dir movement values
        moveDirIncrements = new HashMap<>();
        moveDirIncrements.put(Player.Direction.UP, new Vector2(0, 1));
        moveDirIncrements.put(Player.Direction.DOWN, new Vector2(0, -1));
        moveDirIncrements.put(Player.Direction.LEFT, new Vector2(-1, 0));
        moveDirIncrements.put(Player.Direction.RIGHT, new Vector2(1, 0));

        //lookup for tile types
        tiles = new HashMap<>();
        tiles.put(Tiles.WALL, wall);
        tiles.put(Tiles.STAIRS_DOWN, stairDown);
        tiles.put(Tiles.STAIRS_UP, stairUp);
        tiles.put(Tiles.DOOR, door);
    }
}
