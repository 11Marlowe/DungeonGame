package com.dungeon.game.systems.ui.UIItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIStatDisplay extends UIItem {

    private String statName;

    public UIStatDisplay(Texture defaultTex, Vector2 pos, String statName) {
        super(defaultTex, pos);
        this.statName = statName;
        text = "0";
    }

    @Override
    public void render(SpriteBatch batch, BitmapFont font) {
        checkPlayerStats();
        super.render(batch, font);
    }

    private void checkPlayerStats() {
        // todo: get player stat for stat name and update text
    }
}
