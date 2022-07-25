package com.dungeon.game.systems.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.systems.interaction.Interaction;

import java.util.HashMap;
import java.util.function.Consumer;

public class UISystem {

    public HashMap<Integer, UIItem> uiItemsOnScreen;
    private int uiCounter;


    public UISystem() {
        uiItemsOnScreen = new HashMap<>();
        uiCounter = 0;
    }

    public void renderUI(SpriteBatch batch) {
        for (UIItem item : uiItemsOnScreen.values()) {
            batch.draw(item.tex, item.pos.x, item.pos.y);
        }
    }

}
