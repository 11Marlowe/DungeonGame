package com.dungeon.game.systems.interaction;

import com.dungeon.game.DungeonGame;
import com.dungeon.game.screens.TestGameScreen;
import com.dungeon.game.entities.Entity;
import com.dungeon.game.entities.mapEntities.Door;
import com.dungeon.game.entities.player.PlayerInfo;
import com.dungeon.game.systems.events.Event;
import com.dungeon.game.systems.events.EventArgs;
import com.dungeon.game.systems.interaction.interactions.DoorInteraction;

import java.util.function.Consumer;

public class InteractSystem {

    public Interaction currentInteraction;
    public Event interactionCreated;

    public InteractSystem() {
        interactionCreated = new Event();
    }

    public Consumer<EventArgs> createInteraction = args -> {
        PlayerInfo playerInfo = DungeonGame.playerInfo;
        Entity entity = (Entity)args.args;
        createInteraction(entity);
        playerInfo.state = PlayerInfo.State.INTERACTING;
    };

    private void createInteraction(Entity entity) {

        if (entity instanceof Door) {
            currentInteraction = new DoorInteraction((Door)entity);
            interactionCreated.broadcast(new EventArgs(currentInteraction));
        }

    }

    public Consumer<EventArgs> cancelInteraction = args -> {

        PlayerInfo playerInfo = DungeonGame.playerInfo;

        playerInfo.state = PlayerInfo.State.NONE;
    };
}
