package com.dungeon.game.systems.ui.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.systems.ui.UIItems.UIItem;

public class MenuFactory {


    public MenuFactory() {

    }

    public static UIMenu getCharacterStatsMenu() {

        UIMenu menu = new UIMenu();
        menu.uiBg = new Texture("StatsMenu.png");
        menu.associatedTab = 1;

        // create items
        menu.uiItems.add(new UIItem(new Texture("testportrait.png"), new Vector2(64, 96)));
        menu.uiItems.add(new UIItem(null, new Vector2(160, 128), "Strength:"));
        menu.uiItems.add(new UIItem(null, new Vector2(160, 96), "Magic:"));
        return menu;
    }

    public static UIMenu getGenericMenuForTesting() {
        UIMenu menu = new UIMenu();
        menu.uiBg = new Texture("defaultMenu.png");
        return menu;
    }
}
