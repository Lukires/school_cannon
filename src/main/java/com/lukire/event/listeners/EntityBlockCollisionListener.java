package com.lukire.event.listeners;

import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.EntityBlockCollisionEvent;
import com.lukire.map.tile.TileType;
import processing.core.PVector;

public class EntityBlockCollisionListener implements Listener {

    @EventListener
    public void onCollision(EntityBlockCollisionEvent e) {

        if (e.getTile().getTileType() == TileType.AIR) {
            return;
        }
        e.getEntity().getPlacement().setDirection(new PVector(e.getEntity().getPlacement().getDirection().x, 0));
    }
}
