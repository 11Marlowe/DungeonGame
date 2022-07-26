package com.dungeon.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.dungeon.game.screens.TestGameScreen;


public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		// todo: get screen resolution and other config stuff right
		config.setForegroundFPS(60);
		config.setTitle("DungeonGame");
		config.setWindowedMode(TestGameScreen.SCREEN_WIDTH*4, TestGameScreen.SCREEN_HEIGHT*4);
		new Lwjgl3Application(new DungeonGame(), config);
	}
}
