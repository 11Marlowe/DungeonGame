package com.dungeon.game.systems.UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class UIContainer {

    public List<UIItem> uiItems;

    public UIContainer() {
        uiItems = new ArrayList<>();
    }

    public void draw(SpriteBatch batch, BitmapFont font) {
        for (UIItem uiItem : uiItems) {
            batch.draw(uiItem.tex, uiItem.pos.x, uiItem.pos.y);
        }
    }
}
