package com.lukire.event.events;

import com.lukire.entity.Collision;
import com.lukire.entity.Entity;
import com.lukire.event.Event;
import com.lukire.map.tile.Tile;

import java.util.ArrayList;

public class EntityBlockCollisionEvent extends Event {

    Entity e;
    ArrayList<Collision> collisions;
    public EntityBlockCollisionEvent(Entity e, ArrayList<Collision> collisions) {
        this.e=e;
        this.collisions=collisions;
    }

    public Entity getEntity() {
        return this.e;
    }

    public ArrayList<Collision> getCollisions() {
       return this.collisions;
    }
}
