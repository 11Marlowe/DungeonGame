package com.dungeon.game.systems.ui.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class UITab extends UIItem {

    public int tabNum;
    private Texture inactiveTex;

    public boolean active;

    // todo: this about this in parent class
    public Rectangle clickBox;

    public UITab(int tabNum, Vector2 pos, boolean active) {
        super(new Texture("tabActive.png"), pos);
        this.tabNum = tabNum;
        inactiveTex = new Texture("tabInactive.png");
        this.active = active;
        clickBox = new Rectangle(pos.x, pos.y, 32, 32);
    }

    @Override
    public void render(SpriteBatch batch, BitmapFont font) {
        if (active) {
            batch.draw(defaultTex, pos.x, pos.y);
        } else {
            batch.draw(inactiveTex, pos.x, pos.y);
        }
    }
}
