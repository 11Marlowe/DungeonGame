package com.dungeon.game.systems.ui.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UILabelItem extends UIItem {

    private String text;


    public UILabelItem(Texture tex, Vector2 pos, String text) {
        super(tex, pos);
        this.text = text;
    }

    @Override
    public void draw(SpriteBatch batch, BitmapFont font) {
        batch.draw(defaultTex, pos.x, pos.y);
        font.draw(batch, text, pos.x + 2, pos.y + 20);
    }
}
