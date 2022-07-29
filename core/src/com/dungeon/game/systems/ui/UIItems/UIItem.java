package com.dungeon.game.systems.ui.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIItem {

    public Texture defaultTex;
    public Vector2 pos;

    public String text;

    public UIItem(Texture defaultTex, Vector2 pos) {
        this.defaultTex = defaultTex;
        this.pos = pos;
    }

    public UIItem(Texture defaultTex, Vector2 pos, String text) {
        this.defaultTex = defaultTex;
        this.pos = pos;
        this.text = text;
    }

    public void draw(SpriteBatch batch, BitmapFont font) {
        if (defaultTex != null) {
            batch.draw(defaultTex, pos.x, pos.y);
        }

        if (text != null) {
            font.draw(batch, text, pos.x + 15, pos.y +20);
        }
    }
}
