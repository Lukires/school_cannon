package com.lukire.entity;

import com.lukire.map.tile.Tile;

public class Collision<T> {

    float x, y;
    T object;

    public Collision(T object, float x, float y) {
        this.x=x;
        this.y=y;
        this.object=object;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public T getObject() {
        return this.object;
    }
}
