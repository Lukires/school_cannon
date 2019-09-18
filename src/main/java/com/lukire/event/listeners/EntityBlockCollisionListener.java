package com.lukire.event.listeners;

import com.lukire.entity.*;
import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.EntityBlockCollisionEvent;
import com.lukire.map.tile.Tile;
import com.lukire.map.tile.TileType;
import processing.core.PVector;

import java.util.ArrayList;

public class EntityBlockCollisionListener implements Listener {

    @EventListener
    public void onCollision(EntityBlockCollisionEvent e) {

        /*if (e.getTile().getTileType() == TileType.AIR) {
            return;
        }*/
        //e.getEntity().getPlacement().setDirection(new PVector(e.getEntity().getPlacement().getDirection().x, -1*e.getEntity().getPlacement().getDirection().y*((EntityCollision) e.getEntity()).getElasticity()));

        Entity entity = e.getEntity();
        if (!(entity instanceof EntityCollision)) {
            return;
        }

        ArrayList<Tile> tiles = e.getTiles();
        Placement placement = e.getEntity().getPlacement();
        PVector direction = placement.getDirection();
        Hitbox hitbox = ((EntityCollision) entity).getHitbox();

        float entityCenterX = placement.getX()+(hitbox.getWidth()/2);
        float entityCenterY = placement.getY()-(hitbox.getHeight()/2);
        float elasticity = ((EntityCollision) entity).getElasticity();


        int xMean = 0;
        int yMean = 0;
        int n = 0;
        for (Tile tile : tiles) {
            int tileX = tile.getX()+(Tile.getSize()/2);
            int tileY = tile.getY()-((Tile.getSize()/2));

        }




    }
}
