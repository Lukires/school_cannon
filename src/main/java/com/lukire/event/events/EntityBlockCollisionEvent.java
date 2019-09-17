package com.lukire.event.events;

import com.lukire.entity.Entity;
import com.lukire.event.Event;
import com.lukire.map.tile.Tile;

import java.util.ArrayList;

public class EntityBlockCollisionEvent extends Event {

    Entity e;
    ArrayList<Tile> tiles;
    public EntityBlockCollisionEvent(Entity e, ArrayList<Tile> tiles) {
        this.e=e;
        this.tiles=tiles;
    }

    public Entity getEntity() {
        return this.e;
    }

    public ArrayList<Tile> getTiles() {
       return this.tiles;
    }
}
