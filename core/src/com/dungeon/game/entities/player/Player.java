package com.dungeon.game.entities.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entities.Entity;

import javax.swing.*;

public class Player extends Entity {

    public static final int PLAYER_ID = 0;

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

    public Player() {
        this.tex = new Texture("play.png");
        this.pos = new Vector2(32, 32);
        state =  State.NONE;
    }
}
