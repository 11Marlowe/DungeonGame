package com.dungeon.game.systems;

import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.TestGameScreen;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.events.EventArgs;

import java.util.function.Consumer;

public class MovementSystem {

    private final int step = 32;

    public MovementSystem() {

    }

    public Consumer<EventArgs> movePlayer = args -> {
        Player.Direction dir = (Player.Direction)args.args;
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
        Player player = TestGameScreen.getPlayer();
        player.pos.x += stepx;
        player.pos.y += stepy;
    }

    public Consumer<EventArgs> changePlayerDir = args -> {
        Player.Direction dir = (Player.Direction)args.args;
        Player player = TestGameScreen.getPlayer();
        player.direction = dir;
    };

}
