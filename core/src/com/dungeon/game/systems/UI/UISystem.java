package com.dungeon.game.systems.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.DungeonGame;
import com.dungeon.game.entities.Entity;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.systems.UI.UIItems.UILabelItem;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.interaction.Interaction;

import java.util.HashMap;
import java.util.function.Consumer;

public class UISystem {

    private UIContainer currentContainer;
    private BitmapFont font;
    // todo: just for testing
    private Texture labelTex;

    public UISystem() {
        font = new BitmapFont(Gdx.files.internal("GameFont.fnt"));
        labelTex = new Texture("TextBg.png");
    }

    public void renderUI(SpriteBatch batch) {
        if (currentContainer != null) {
            currentContainer.draw(batch, font);
        }
    }

    public Consumer<EventArgs> openMainMenu = args -> {
        currentContainer = new UIContainer();
    };

    public Consumer<EventArgs> createUIForInteraction = args -> {
        Interaction interaction = (Interaction) args.args;
        currentContainer = new UIContainer();
        UIItem uiItem = new UILabelItem(labelTex, new Vector2(0, 0), interaction.getTextForInteraction());
        currentContainer.uiItems.add(uiItem);
    };

    public Consumer<EventArgs> cancelUIForInteraction = args -> {
        currentContainer = null;
    };

    public void findInteractedWithUiItemInContainer() {

    }

}
