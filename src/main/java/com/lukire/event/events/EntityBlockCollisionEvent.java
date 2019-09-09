package com.lukire.event.events;

import com.lukire.entity.Entity;
import com.lukire.event.Event;
import com.lukire.map.tile.Tile;

public class EntityBlockCollisionEvent extends Event {

    Entity e;
    Tile tile;
    public EntityBlockCollisionEvent(Entity e, Tile tile) {
        this.e=e;
        this.tile=tile;
    }

    public Entity getEntity() {
        return this.e;
    }

    public Tile getTile() {
       return this.tile;
    }
}
