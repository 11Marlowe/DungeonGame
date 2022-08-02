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
import com.dungeon.game.systems.ui.menus.MenuFactory;
import com.dungeon.game.systems.ui.menus.UIMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class MainMenuUiSystem {

    private BitmapFont font;
    private Texture mainMenuBg;
    private HashMap<Integer, UIMenu> uiMenuTabMap;
    private UIMenu current;
    private Vector2 mainMenuPos;
    private List<UITab> tabs;


    public MainMenuUiSystem() {
        font = new BitmapFont(Gdx.files.internal("GameFont.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(0.25f, 0.25f);
        mainMenuBg = new Texture("menuBG.png");
        uiMenuTabMap = new HashMap<>();
        mainMenuPos = new Vector2(32, 32);
        tabs = new ArrayList<>();
        tabs.add(new UITab(1, new Vector2(32, 128), true));
        tabs.add(new UITab(2, new Vector2(32, 96), false));
        tabs.add(new UITab(3, new Vector2(32, 64), false));
        tabs.add(new UITab(4, new Vector2(32, 32), false));
        UIMenu stats = MenuFactory.getCharacterStatsMenu();
        uiMenuTabMap.put(stats.associatedTab, stats);
        uiMenuTabMap.put(2, MenuFactory.getGenericMenuForTesting());
        uiMenuTabMap.put(3, MenuFactory.getGenericMenuForTesting());
        uiMenuTabMap.put(4, MenuFactory.getGenericMenuForTesting());
        uiMenuTabMap.put(5, MenuFactory.getGenericMenuForTesting());
        current = stats;
    }

    public void renderMainMenu(SpriteBatch batch) {
        if (DungeonGame.playerInfo.state == PlayerInfo.State.IN_MAIN_MENU) {
            batch.draw(mainMenuBg, mainMenuPos.x, mainMenuPos.y);
            current.renderMenu(batch, font);

            for (UITab uiTab : tabs) {
                uiTab.render(batch, font);
            }
        }
    }

    public Consumer<EventArgs> handleMainMenuClick = args -> {
        Vector2 clickedCoords = (Vector2)args.args;
        // check tabs first
        boolean tabClicked = checkTabsForClick(clickedCoords);
        if (tabClicked) {
            return;
        }
        // check rest of ui

    };

    private boolean checkTabsForClick(Vector2 clickedCoords) {
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
            current = uiMenuTabMap.get(clickedTab.tabNum);
            return true;
        }
        return false;
    }

}
