package com.dungeon.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dungeon.game.DungeonGame;
import com.dungeon.game.entities.Entity;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.InputSystem;
import com.dungeon.game.systems.UI.UISystem;
import com.dungeon.game.systems.interaction.InteractSystem;
import com.dungeon.game.systems.map.MapSystem;
import com.dungeon.game.systems.MovementSystem;

import java.util.HashMap;

public class TestGameScreen extends ScreenAdapter {

    //static hashmap of entities so player doesn't need to be passed in
    // todo: probably need to find a better solution
    public static HashMap<Integer, Entity> entities;

    public static final int SCREEN_WIDTH = 320;
    public static final int SCREEN_HEIGHT = 180;

    private final DungeonGame game;
    private final OrthographicCamera camera;
    private final Player player;
    private final InputSystem inputSystem;
    private final MovementSystem movementSystem;
    private final MapSystem mapSystem;
    private final InteractSystem interactSystem;
    private final UISystem uiSystem;

    public TestGameScreen(final DungeonGame game) {
        this.game = game;
        camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.translate(SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        player = new Player();
        entities = new HashMap<>();
        entities.put(Player.PLAYER_ID, player);
        //init systems
        inputSystem  = new InputSystem();
        Gdx.input.setInputProcessor(inputSystem);
        movementSystem = new MovementSystem();
        mapSystem = new MapSystem();
        interactSystem = new InteractSystem();
        uiSystem = new UISystem();
        //connect events
        inputSystem.moveKeyPressed.addListener(mapSystem.checkPlayerMapPosForMove);
        inputSystem.moveKeyPressed.addListener(movementSystem.changePlayerDir);
        inputSystem.interactKeyPressedStateNone.addListener(mapSystem.checkMapForInteraction);

        mapSystem.playerCanMove.addListener(movementSystem.movePlayer);
        mapSystem.interactionFound.addListener(interactSystem.createInteraction);
    }


    @Override
    public void render(float delta) {
        // screen/camera stuff
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // just for testing
//        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
//            camera.zoom += 0.2;
//        }

        // render/draw everything
        game.batch.begin();

        mapSystem.renderMap(game.batch);
        game.batch.draw(player.tex, player.pos.x, player.pos.y);
        uiSystem.renderUI(game.batch);

        game.batch.end();
    }

    public static Player getPlayer() {
        return (Player) entities.get(Player.PLAYER_ID);
    }

    @Override
    public void dispose() {
    }
}
