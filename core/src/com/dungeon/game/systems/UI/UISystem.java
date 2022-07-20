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
    public HashMap<Interaction.Type, UIItem> uiItems;
    private int uiCounter;


    public UISystem() {
        uiItemsOnScreen = new HashMap<>();
        uiItems = new HashMap<>();
        uiCounter = 0;
        initUiItems();
    }

    public void renderUI(SpriteBatch batch) {
        for (UIItem item : uiItemsOnScreen.values()) {
            batch.draw(item.tex, item.pos.x, item.pos.y);
        }
    }

    public void createVisualForInteraction(Interaction interaction) {
        uiItemsOnScreen.put(Interaction.interactionID, uiItems.get(interaction.type));
    }

    public void removeVisualForInteraction() {
        uiItemsOnScreen.remove(Interaction.interactionID);
    }

    private void initUiItems() {
        uiItems.put(Interaction.Type.LOCKED_DOOR, new UIItem(new Texture(Gdx.files.internal("locked.png")), new Vector2(0,0)));
    }
}
