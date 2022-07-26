package com.dungeon.game.entities.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entities.Entity;

public class PlayerInfo extends Entity {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public enum State {
        NONE,
        INTERACTING
    }

    public State state;
    public Direction direction;

    public PlayerInfo() {
        this.tex = new Texture("play.png");
        this.pos = new Vector2(32, 32);
        state =  State.NONE;
        direction = Direction.UP;
    }
}
