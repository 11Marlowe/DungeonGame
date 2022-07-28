package com.dungeon.game.systems.ui.containers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class UIContainer {

    private List<UITable> uiTables;
    private UITable current;
    private Texture uiBg;
    private Vector2 pos;

    public UIContainer() {
        uiTables = new ArrayList<>();
        uiBg = new Texture("");
    }

    public void draw(SpriteBatch batch, BitmapFont font) {
        batch.draw(uiBg, pos.x, pos.y);
    }
}
