package com.dungeon.game.systems.interaction;

import com.dungeon.game.screens.TestGameScreen;
import com.dungeon.game.entities.Entity;
import com.dungeon.game.entities.mapEntities.Door;
import com.dungeon.game.entities.player.Player;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.interaction.interactions.DoorInteraction;

import java.util.function.Consumer;

public class InteractSystem {

    public Interaction currentInteraction;

    public InteractSystem() {

    }

    public Consumer<EventArgs> createInteraction = args -> {
        Player player = TestGameScreen.getPlayer();
        Entity entity = (Entity)args.args;
        createInteraction(entity);
        player.state = Player.State.INTERACTING;
    };

    private void createInteraction(Entity entity) {

        if (entity instanceof Door) {
            currentInteraction = new DoorInteraction((Door)entity);
        }

    }
}
