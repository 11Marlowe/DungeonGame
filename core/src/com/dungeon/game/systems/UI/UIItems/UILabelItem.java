package com.dungeon.game.systems.UI.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.systems.UI.UIItem;

public class UILabelItem extends UIItem {

    private String text;


    public UILabelItem(Texture tex, Vector2 pos, String text) {
        super(tex, pos);
        this.text = text;
    }

    @Override
    public void draw(SpriteBatch batch, BitmapFont font) {
        batch.draw(tex, pos.x, pos.y);
        font.draw(batch, text, pos.x, pos.y);
    }
}
