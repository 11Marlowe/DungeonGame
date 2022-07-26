package com.dungeon.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.screens.TestGameScreen;

public class DungeonGame extends Game {
	public SpriteBatch batch;
	public static PlayerInfo playerInfo;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		playerInfo = new PlayerInfo();
		this.setScreen(new TestGameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
