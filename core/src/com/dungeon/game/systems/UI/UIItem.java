package com.dungeon.game.systems.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIItem {

    public Texture tex;
    public Texture interactedWithTex;
    public Vector2 pos;

    public boolean interactable;

    public UIItem(Texture tex, Texture interactedWithTex, boolean interactable,  Vector2 pos) {
        this.interactable = interactable;
        this.tex = tex;
        this.interactedWithTex = interactedWithTex;
        this.pos = pos;
    }

    public UIItem(Texture tex, Vector2 pos) {
        this.interactable = false;
        this.tex = tex;
        this.pos = pos;
    }

    public void draw(SpriteBatch batch, BitmapFont font) {

    }
}
