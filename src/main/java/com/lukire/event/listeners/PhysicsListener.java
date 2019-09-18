package com.lukire.event.listeners;

import com.lukire.entity.*;
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


    private ArrayList<Tile> collidedTiles = new ArrayList<Tile>();


    private void addCollidedTile(Tile tile) {
        if (tile != null) {
            if (tile.getTileType().isCollidable()) {
                if (!collidedTiles.contains(tile)) {
                    collidedTiles.add(tile);
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

            System.out.println("SPF "+e.getSecondPerFrame());

            if (((EntityPhysics) entity).affectedByGravity()) {
                placement.addDirection(new PVector((float) 0, (float) (EntityPhysics.GRAVITATIONAL_CONSTANT * e.getSecondPerFrame())));
            }

            System.out.println(placement.getY());
            entity.setPlacement(placement);


            Map map = placement.getMap();
            if (entity instanceof EntityCollision) {
                Hitbox hitbox = ((EntityCollision) entity).getHitbox();
                int width = hitbox.getWidth();
                int height = hitbox.getHeight();

                float px = placement.getX();
                float py = placement.getY();

                if (hitbox.getEntityShape().equals(EntityShape.SQUARE)) {
                    for (int x = 0; x < width; x++) {

                        //TOP OF THE SQUARE
                        addCollidedTile(map.getTile((int)px+x, (int)py));

                        //BOTTOM OF THE SQUARE
                        addCollidedTile(map.getTile((int)px+x, (int)px-height));
                    }

                    for (int y = height; y > 0; y--) {
                        //LEFT SIDE OF SQUARE
                        addCollidedTile(map.getTile((int)px, (int)py+y));

                        //RIGHT SIDE OF SQUARE
                        addCollidedTile(map.getTile((int)py+width, (int)py+y));
                    }
                }

                if (!collidedTiles.isEmpty()) {
                    EventHandler.trigger(new EntityBlockCollisionEvent(entity, collidedTiles));
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
