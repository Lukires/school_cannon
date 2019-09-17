package com.lukire.entity;

import com.lukire.map.Map;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class Entity {


    private static ArrayList<Entity> entities = new ArrayList<Entity>();


    Placement placement;

    public Placement getPlacement() {
        return this.placement;
    }

    public void setPlacement(Placement placement) {
        this.placement=placement;
    }
    public static ArrayList<Entity> getEntities() { return entities; }

    public float getX() {
        return placement.getX();
    }

    public float getY() {
        return placement.getY();
    }

    public void setX(float x) { placement.x=x; }

    public void setY(float y) { placement.y=y; }

    public abstract void draw(PApplet screen);

    public static void spawn(Entity e, Placement placement) {
        e.setPlacement(placement);
        entities.add(e);
    }

    public boolean collidesBlock() {
       /* Map map = placement.getMap();
        int x = (int)placement.getX();
        int y = (int)placement.getY();
        return map.getChunkFromGameLocation(x, y).getTileFromGameCoordinate(x,y) != null
                && map.getChunkFromGameLocation(x+getSize(), y+getSize()).getTileFromGameCoordinate(x+getSize(),y+getSize()) != null;*/

       return false;
    }
}
