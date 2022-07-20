package com.dungeon.game.systems;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.dungeon.game.TestGameScreen;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.events.Event;
import com.dungeon.game.systems.events.EventArgs;

public class InputSystem implements InputProcessor {

    private final Player player;
    public Event moveKeyPressed;
    public Event interactKeyPressed;

    public InputSystem() {
        player = TestGameScreen.getPlayer();
        moveKeyPressed = new Event();
        interactKeyPressed = new Event();
    }

    @Override
    public boolean keyDown(int keycode) {
        // needs to be done if state is NONE
        switch (keycode)
        {
            case Input.Keys.LEFT:
                moveKeyPressed.broadcast(new EventArgs(Player.Direction.LEFT));
                break;
            case Input.Keys.RIGHT:
                moveKeyPressed.broadcast(new EventArgs(Player.Direction.RIGHT));
                break;
            case Input.Keys.UP:
                moveKeyPressed.broadcast(new EventArgs(Player.Direction.UP));
                break;
            case Input.Keys.DOWN:
                moveKeyPressed.broadcast(new EventArgs(Player.Direction.DOWN));
                break;
            case Input.Keys.A:
                interactKeyPressed.broadcast(new EventArgs());
                break;
        }

        // code for state is interacting
        return false;
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
