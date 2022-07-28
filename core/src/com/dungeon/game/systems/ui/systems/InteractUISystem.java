package com.dungeon.game.systems.ui.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeon.game.systems.ui.containers.UIContainer;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.interaction.Interaction;

import java.util.function.Consumer;

public class InteractUISystem {

    // todo: further abstract this into more systems main menu, interaction, map etc

    private UIContainer currentContainer;
    private BitmapFont font;
    // todo: just for testing
    private Texture labelTex;

    public InteractUISystem() {
        font = new BitmapFont(Gdx.files.internal("GameFont.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(0.22f, 0.25f);
        labelTex = new Texture("TextBg.png");
        // create UI containers for game
    }

    public void renderUI(SpriteBatch batch) {
        if (currentContainer != null) {
            currentContainer.draw(batch, font);
        }
    }


    // todo: come back after main menu functionality
    public Consumer<EventArgs> createUIForInteraction = args -> {
        Interaction interaction = (Interaction) args.args;
    };

    public Consumer<EventArgs> cancelUIForInteraction = args -> {
        currentContainer = null;
    };

    public void findInteractedWithUiItemInContainer() {

    }

}
