package com.lukire.event.listeners;

import com.lukire.entity.*;
import com.lukire.entity.attributes.EntityCollision;
import com.lukire.entity.attributes.EntityPhysics;
import com.lukire.event.EventHandler;
import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.EntityBlockCollisionEvent;
import com.lukire.event.events.NewFrameEvent;
import com.lukire.map.Map;
import com.lukire.map.tile.Tile;
import processing.core.PVector;

import java.util.ArrayList;

public class PhysicsListener implements Listener {

    /*

    We apply all forces to the entity every frame
    Use use second per frame, so the physics don't change based on your fps.

     */


    private ArrayList<Collision> collidedTiles = new ArrayList<Collision>();


    private void addCollidedTile(Tile tile, float x, float y) {
        if (tile != null) {
            if (tile.getTileType().isCollidable()) {
                if (!collidedTiles.contains(tile)) {
                    collidedTiles.add(new Collision(tile, x, y));
                }
            }
        }
    }
    @EventListener
    public void onFrame(NewFrameEvent e) {

        for (Entity entity : Entity.getEntities()) {

            if (!(entity instanceof EntityPhysics)) {
                return;
            }


            Placement placement = entity.getPlacement();

            if (((EntityPhysics) entity).affectedByGravity()) {
                placement.addDirection(new PVector((float) 0, (float) (EntityPhysics.GRAVITATIONAL_CONSTANT * e.getSecondPerFrame())));
            }


            Map map = placement.getMap();
            if (entity instanceof EntityCollision) {
                Hitbox hitbox = ((EntityCollision) entity).getHitbox();
                int width = hitbox.getWidth();
                int height = hitbox.getHeight();

                float px = placement.getX()+placement.getDirection().x;
                float py = placement.getY()+placement.getDirection().y;

                if (hitbox.getEntityShape().equals(EntityShape.SQUARE)) {
                    for (int x = 0; x < width; x++) {
                        //System.out.println("X: "+(x+px));
                        //TOP OF THE SQUARE
                        addCollidedTile(map.getTile((int)px+x, (int)py), px+x, py);

                        //BOTTOM OF THE SQUARE
                        addCollidedTile(map.getTile((int)px+x, (int)py+height), px+x, py+height);
                    }

                    for (int y = 0; y < height; y++) {
                        //LEFT SIDE OF SQUARE
                        addCollidedTile(map.getTile((int)px, (int)py+y), px, py+y);

                        //RIGHT SIDE OF SQUARE
                        addCollidedTile(map.getTile((int)px+width, (int)py+y), px+width, py+y);

                    }
                }

                if (!collidedTiles.isEmpty()) {
                    //System.out.println("Size: "+collidedTiles.size());
                    EventHandler.trigger(new EntityBlockCollisionEvent(entity, collidedTiles));
                    collidedTiles.clear();
                }

            }
            placement.applyDirection();
            //Placement placement = entity.getPlacement();

            /*if (entity instanceof Collidable) {
                if (((Collidable) entity).isCollidable()) {
                    Map map = placement.getMap();

                    int x = (int)entity.getX()+entity.getSize()+Tile.getSize();
                    int y = (int)entity.getY()+entity.getSize()+Tile.getSize();


                    Tile tile = map.getChunkFromGameLocation(x,y).getTileFromGameCoordinate(x,y);
                    if (tile != null) {
                        EventHandler.trigger(new EntityBlockCollisionEvent(entity, tile));
                    }
                }
            }*/




            //placement.applyDirection();
            //Temporary draw update
            //Should update individual chunks instead of whole map!
            //SLOWS DOWN PROGRAM DRASTICALLY

            //if (placement.getDirection().y!=0) map.draw(e.getScreen());

        }

    }

}
