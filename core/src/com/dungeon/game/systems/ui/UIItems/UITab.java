package com.dungeon.game.systems.ui.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UITab extends UIItem {

    public int tabNum;
    private Texture inactiveTex;

    public boolean active;

    public UITab(int tabNum, Vector2 pos) {
        super(new Texture("tabActive.png"), pos);
        this.tabNum = tabNum;
        inactiveTex = new Texture("tabInactive.png");
    }

    @Override
    public void draw(SpriteBatch batch, BitmapFont font) {
        if (active) {
            batch.draw(defaultTex, pos.x, pos.y);
        } else {
            batch.draw(inactiveTex, pos.x, pos.y);
        }
    }
}
