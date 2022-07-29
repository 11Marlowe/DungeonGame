package com.dungeon.game.systems.ui.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.systems.ui.UIItems.UIItem;

import java.util.ArrayList;
import java.util.List;

public class UIMenu {


    public List<UIItem> uiItems;
    public Texture uiBg;
    private Vector2 pos;

    public Integer associatedTab;

    public UIMenu() {
        uiItems = new ArrayList<>();
        this.pos = new Vector2(64, 32);
    }

    public void renderMenu(SpriteBatch batch, BitmapFont font) {
        batch.draw(uiBg, pos.x, pos.y);

        for (UIItem uiItem : uiItems) {
            uiItem.draw(batch, font);
        }
    }
}
