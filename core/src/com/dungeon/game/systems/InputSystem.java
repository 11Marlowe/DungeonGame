package com.dungeon.game.systems;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.dungeon.game.DungeonGame;
import com.dungeon.game.screens.TestGameScreen;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.systems.events.Event;
import com.dungeon.game.systems.events.EventArgs;

public class InputSystem implements InputProcessor {

    private final PlayerInfo playerInfo;
    public Event moveKeyPressed;
    public Event interactKeyPressedStateNone;
    public Event interactKeyPressedStateInteracting;

    public Event mainMenuKeyPressed;

    public InputSystem() {
        playerInfo = DungeonGame.playerInfo;
        moveKeyPressed = new Event();
        interactKeyPressedStateNone = new Event();
        interactKeyPressedStateInteracting = new Event();
        mainMenuKeyPressed = new Event();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (playerInfo.state == PlayerInfo.State.NONE) {
            handleNoneStateInput(keycode);
        } else if (playerInfo.state == PlayerInfo.State.INTERACTING) {
            handleInteractingStateInput(keycode);
        } else if (playerInfo.state == PlayerInfo.State.IN_MAIN_MENU) {
            handleMainMenuStateKeyboardInput(keycode);
        }
        return false;
    }

    private void handleMainMenuStateKeyboardInput(int keycode) {
        if (keycode == Input.Keys.Q) {
            interactKeyPressedStateInteracting.broadcast(new EventArgs());
            playerInfo.state = PlayerInfo.State.NONE;
        }
    }

    private void handleInteractingStateInput(int keycode) {
        if (keycode == Input.Keys.E) {
            playerInfo.state = PlayerInfo.State.NONE;
        }
    }

    private void handleNoneStateInput(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                moveKeyPressed.broadcast(new EventArgs(PlayerInfo.Direction.LEFT));
                break;
            case Input.Keys.RIGHT:
                moveKeyPressed.broadcast(new EventArgs(PlayerInfo.Direction.RIGHT));
                break;
            case Input.Keys.UP:
                moveKeyPressed.broadcast(new EventArgs(PlayerInfo.Direction.UP));
                break;
            case Input.Keys.DOWN:
                moveKeyPressed.broadcast(new EventArgs(PlayerInfo.Direction.DOWN));
                break;
            case Input.Keys.E:
                playerInfo.state = PlayerInfo.State.INTERACTING;
                interactKeyPressedStateNone.broadcast(new EventArgs());
                break;
            case Input.Keys.Q:
                playerInfo.state = PlayerInfo.State.IN_MAIN_MENU;
                break;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}
