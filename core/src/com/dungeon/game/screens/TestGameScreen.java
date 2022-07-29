package com.dungeon.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dungeon.game.DungeonGame;
import com.dungeon.game.systems.InputSystem;
import com.dungeon.game.systems.map.MapSystem;
import com.dungeon.game.systems.MovementSystem;
import com.dungeon.game.systems.ui.systems.MainMenuUiSystem;

public class TestGameScreen extends ScreenAdapter {

    // todo: this is a temp game screen while i test things

    public static final int SCREEN_WIDTH = 320;
    public static final int SCREEN_HEIGHT = 180;

    private final DungeonGame game;
    private final OrthographicCamera camera;
    private final InputSystem inputSystem;
    private final MovementSystem movementSystem;
    private final MapSystem mapSystem;
    private final MainMenuUiSystem mainMenuUiSystem;

    public TestGameScreen(final DungeonGame game) {
        this.game = game;
        camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.translate(SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        //init systems
        inputSystem  = new InputSystem(camera);
        Gdx.input.setInputProcessor(inputSystem);
        movementSystem = new MovementSystem();
        mapSystem = new MapSystem();
        mainMenuUiSystem = new MainMenuUiSystem();
        //connect events
        inputSystem.moveKeyPressed.addListener(mapSystem.checkPlayerMapPosForMove);
        inputSystem.moveKeyPressed.addListener(movementSystem.changePlayerDir);
        inputSystem.interactKeyPressedStateNone.addListener(mapSystem.checkMapForInteraction);
        inputSystem.clickedWhileInMainMenu.addListener(mainMenuUiSystem.handleMainMenuClick);
        //inputSystem.interactKeyPressedStateInteracting.addListener(uiSystem.cancelUIForInteraction);

        mapSystem.playerCanMove.addListener(movementSystem.movePlayer);
        //mapSystem.interactionFound.addListener(uiSystem.createUIForInteraction);


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
        game.batch.draw(DungeonGame.playerInfo.tex, DungeonGame.playerInfo.pos.x, DungeonGame.playerInfo.pos.y);
        mainMenuUiSystem.renderMainMenu(game.batch);

        game.batch.end();
    }

    @Override
    public void dispose() {
        // todo: dispose of things
    }
}
