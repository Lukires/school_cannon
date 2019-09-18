package com.lukire.map.tile;

import processing.core.PApplet;

public abstract class Tile {


    private float health = 100f;

    private TileType tile;
    private int x, y;
    public Tile(TileType tile, int x, int y) {
        this.x=x;
        this.y=y;
        this.tile=tile;
    }

    public TileType getTileType() {
        return tile;
    }

    public float getHealth() {
        return health;
    }

    public void subtractHealth(float i) {
        this.health-=i;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    private static final int size = 8;
    public static int getSize() {
        return size;
    }

    public void draw(PApplet p, int x, int y) {
        short[] rgb = tile.getRGB();
        p.fill(rgb[0], rgb[1], rgb[2]);
        p.rect(x, y, Tile.getSize(), Tile.getSize());

        //System.out.println(String.format("[%s, %s, %s]",x,y,Tile.getSize()));

    }

}
