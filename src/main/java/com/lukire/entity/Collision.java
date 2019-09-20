package com.lukire.entity;

import com.lukire.map.tile.Tile;

public class Collision {

    float x, y;
    Tile tile;

    public Collision(Tile tile, float x, float y) {
        this.x=x;
        this.y=y;
        this.tile=tile;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Tile getTile() {
        return this.tile;
    }
}
