package com.dungeon.game.systems.events;

public class EventArgs {

    public Object args;

    public EventArgs(Object args) {
        this.args = args;
    }

    public EventArgs() {
        args = null;
    }
}
