package com.dungeon.game.systems.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.DungeonGame;
import com.dungeon.game.entities.Entity;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.interaction.Interaction;

import java.util.HashMap;
import java.util.function.Consumer;

public class UISystem {

    // todo: find some better solution to drawing the ui items
    public HashMap<Integer, UIItem> uiItemsOnScreen;
    private BitmapFont font;

    public UISystem() {
        uiItemsOnScreen = new HashMap<>();
        font = new BitmapFont(Gdx.files.internal("GameFont.fnt"));
    }

    public void renderUI(SpriteBatch batch) {
        for (UIItem item : uiItemsOnScreen.values()) {
            batch.draw(item.tex, item.pos.x, item.pos.y);
        }
    }

    public Consumer<EventArgs> createUIForInteraction = args -> {
        Interaction interaction = (Interaction) args.args;

    };

    public Consumer<EventArgs> cancelUIForInteraction = args -> {

    };

}
