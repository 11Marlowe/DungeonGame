package com.dungeon.game.systems.ui.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.DungeonGame;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.ui.UIItems.UITab;
import com.dungeon.game.systems.ui.containers.UIContainer;
import com.dungeon.game.systems.ui.containers.UITable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class MainMenuUiSystem {

    private BitmapFont font;
    private Texture mainMenuBg;
    private HashMap<Integer, UITable> uiTableTabMap;
    private UITable current;
    private Vector2 mainMenuPos;
    private List<UITab> tabs;


    public MainMenuUiSystem() {
        font = new BitmapFont(Gdx.files.internal("GameFont.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(0.22f, 0.25f);
        mainMenuBg = new Texture("menuBG.png");
        uiTableTabMap = new HashMap<>();
        mainMenuPos = new Vector2(32, 32);
        tabs = new ArrayList<>();
        tabs.add(new UITab(1, new Vector2(32, 128), true));
        tabs.add(new UITab(2, new Vector2(32, 96), false));
        tabs.add(new UITab(3, new Vector2(32, 64), false));
        tabs.add(new UITab(4, new Vector2(32, 32), false));
        current = new UITable();
    }

    public void renderMainMenu(SpriteBatch batch) {
        if (DungeonGame.playerInfo.state == PlayerInfo.State.IN_MAIN_MENU) {
            batch.draw(mainMenuBg, mainMenuPos.x, mainMenuPos.y);
            current.renderUITable(batch);

            for (UITab uiTab : tabs) {
                uiTab.draw(batch, font);
            }
        }
    }

    public Consumer<EventArgs> handleMainMenuClick = args -> {
        Vector2 clickedCoords = (Vector2)args.args;
        // check tabs first
        UITab clickedTab = null;
        UITab currentActiveTab = null;
        for (UITab uiTab : tabs) {
            if (uiTab.active) {
                currentActiveTab = uiTab;
            }
            if (uiTab.clickBox.contains(clickedCoords)) {
                clickedTab = uiTab;
            }
        }

        if (clickedTab != null && currentActiveTab != null) {
            currentActiveTab.active = false;
            clickedTab.active = true;
            // open new tab
            return;
        }

        // check rest of ui

    };

}
