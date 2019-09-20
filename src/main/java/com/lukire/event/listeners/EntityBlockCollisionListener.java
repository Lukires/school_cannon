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

        ArrayList<Collision> collisions = e.getCollisions();
        Placement placement = e.getEntity().getPlacement();
        PVector direction = placement.getDirection();
        float xDirection = direction.x;
        float yDirection = direction.y;


        Hitbox hitbox = ((EntityCollision) entity).getHitbox();

        float entityCenterX = placement.getX()+(hitbox.getWidth()/2);
        float entityCenterY = placement.getY()+(hitbox.getHeight()/2);
        float elasticity = ((EntityCollision) entity).getElasticity();


        double xMean = 0;
        double yMean = 0;
        double n = 0;
        for (Collision collision : collisions) {
            Tile tile = collision.getTile();
            int tileX = (int)collision.getX()+(Tile.getSize()/2);
            int tileY = (int)collision.getY()+((Tile.getSize()/2));

            //System.out.println(String.format("TileX: %s, TileY: %s", tileX, tileY));
            //placement.addDirection(new PVector(0.04f, -0.11f));

            double xDis = entityCenterX-tileX;
            double yDis = entityCenterY-tileY;

            //System.out.println(String.format("X: %s, Y: %s, EntityCenter: %s, TileCenterX: %s", xDis, yDis, entityCenterX, tileX));

            //System.out.println((180/Math.PI)*Math.atan(yDis/xDis));

            xMean += xDirection;
            yMean += -1;
            n+=1;
        }

        placement.setDirection(new PVector((float)(xMean/n), (float)0));


    }
}
