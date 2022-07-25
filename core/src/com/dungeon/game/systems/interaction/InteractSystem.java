package com.dungeon.game.systems.interaction;

import com.dungeon.game.TestGameScreen;
import com.dungeon.game.entities.Entity;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.map.MapSystem;

import java.util.function.Consumer;

public class InteractSystem {

    public Interaction currentInteraction;

    public InteractSystem() {

    }

    public Consumer<EventArgs> doInteraction = args -> {
        Player player = TestGameScreen.getPlayer();
        Entity entity = (Entity)args.args;
        player.state = Player.State.INTERACTING;
    };
}
