package com.dungeon.game.systems.interaction;

import com.dungeon.game.TestGameScreen;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.map.MapSystem;

import java.util.function.Consumer;

public class InteractSystem {

    public Interaction currentInteraction;

    public InteractSystem() {
        currentInteraction = new Interaction(Interaction.Type.NONE);
    }

    public Consumer<EventArgs> doInteraction = args -> {
        Player player = TestGameScreen.getPlayer();
        MapSystem.Tiles mapObject = MapSystem.Tiles.valueOf((int)args.args).get();
        player.state = Player.State.INTERACTING;
    };
}
