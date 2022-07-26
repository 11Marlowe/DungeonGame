package com.dungeon.game.systems;

import com.dungeon.game.DungeonGame;
import com.dungeon.game.screens.TestGameScreen;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.systems.events.EventArgs;

import java.util.function.Consumer;

public class MovementSystem {

    private final int step = 32;

    public MovementSystem() {

    }

    public Consumer<EventArgs> movePlayer = args -> {
        PlayerInfo.Direction dir = (PlayerInfo.Direction)args.args;
        switch (dir)
        {
            case LEFT:
                move(-step, 0);
                break;
            case RIGHT:
                move(step, 0);
                break;
            case UP:
                move(0, step);
                break;
            case DOWN:
                move(0, -step);
                break;
        }
    };

    private void move(int stepx, int stepy) {
        PlayerInfo playerInfo = DungeonGame.playerInfo;
        playerInfo.pos.x += stepx;
        playerInfo.pos.y += stepy;
    }

    public Consumer<EventArgs> changePlayerDir = args -> {
        PlayerInfo.Direction dir = (PlayerInfo.Direction)args.args;
        PlayerInfo playerInfo = DungeonGame.playerInfo;
        playerInfo.direction = dir;
    };

}
