package com.lukire.map.tile;

public enum TileType {

    /*

    Strength defines how much it takes to "break" the tile
    RGB MUST have a length of 3, one for R, one for G, and for for B

     */

    DIRT(100, new short[]{133,94,64}, true), STONE(1000, new short[]{139,139,139}, true), AIR(0,new short[]{0,0,0}, false);

    int strength;
    short[] rgb;
    boolean collidable;

    TileType(int strength, short[] rgb, boolean collidable) {
        this.strength=strength;
        this.rgb=rgb;
        this.collidable=collidable;
    }

    public int getStrength() { return this.strength; }
    public short[] getRGB() { return this.rgb; }
    public boolean isCollidable() { return this.collidable; }

}
