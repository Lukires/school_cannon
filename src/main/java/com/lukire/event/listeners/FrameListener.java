package com.lukire.event.listeners;

import com.lukire.entity.Entity;
import com.lukire.entity.Gravity;
import com.lukire.entity.Placement;
import com.lukire.event.EventHandler;
import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.EntityBlockCollisionEvent;
import com.lukire.event.events.NewFrameEvent;
import com.lukire.map.Map;
import com.lukire.map.tile.Tile;
import com.lukire.map.tile.TileType;
import processing.core.PVector;

public class FrameListener implements Listener {
        /*

    We apply all forces to the entity every frame

     */

    @EventListener
    public void onFrame(NewFrameEvent e) {

        for (Entity entity : Entity.getEntities()) {

            Placement placement = entity.getPlacement();

            if (entity instanceof Gravity) {
                placement.addDirection(new PVector(0, Gravity.GRAVITY_CONSTANT));
            }

            Map map = placement.getMap();

            int x = (int)entity.getX()+entity.getSize()+Tile.getSize();
            int y = (int)entity.getY()+entity.getSize()+Tile.getSize();

            Tile tile = map.getChunkFromGameLocation(x,y).getTileFromGameCoordinate(x,y);
            if (tile != null) {
                EventHandler.trigger(new EntityBlockCollisionEvent(entity, tile));
            }

            placement.applyDirection();
            //Temporary draw update
            //Should update individual chunks instead of whole map!
            //SLOWS DOWN PROGRAM DRASTICALLY

            if (placement.getDirection().y!=0) map.draw(e.getScreen());

        }

    }

}
