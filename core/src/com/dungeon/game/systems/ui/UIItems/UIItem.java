package com.dungeon.game.systems.ui.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIItem {

    public Texture defaultTex;
    public Vector2 pos;

    public UIItem(Texture defaultTex, Vector2 pos) {
        this.defaultTex = defaultTex;
        this.pos = pos;
    }

    public void draw(SpriteBatch batch, BitmapFont font) {

    }
}
