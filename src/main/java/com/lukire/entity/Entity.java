package com.lukire.entity;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class Entity {


    private static ArrayList<Entity> entities = new ArrayList<Entity>();

    protected float x;
    protected float y;
    protected  PVector vector;

    public Entity() {

    }

    public float getX() { return this.x; }
    public float getY() { return this.y; }
    public PVector getVector() { return this.vector; }

    public void setX(float x) {
        this.x=x;
    }

    public void setY(float y) {
        this.y=y;
    }

    public void setVector(PVector vector) {
        this.vector=vector;
    }

    public static ArrayList<Entity> getEntities() { return entities; }

    public abstract void draw(PApplet screen);

    public static void spawn(Entity e, float x, float y) {
        e.setX(x);
        e.setY(y);
        entities.add(e);
    }
}
