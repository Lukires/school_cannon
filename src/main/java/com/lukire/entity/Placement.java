package com.lukire.entity;

import com.lukire.map.Map;
import processing.core.PVector;

public class Placement extends PVector {


    Map map;
    PVector direction = new PVector();

    public Placement(Map map, float x, float y) {
        this.x=x;
        this.y=y;
        this.map=map;
    }

    public Map getMap() { return this.map; }

    public void addDirection(PVector direction) {
        this.direction.add(direction);
    }

    public PVector getDirection() {
        return this.direction;
    }

    public void applyDirection() {
        add(direction);
    }

    public void setDirection(PVector direction) { this.direction=direction; }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
