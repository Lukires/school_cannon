package com.lukire.map.tile;

public enum TileType {

    DIRT(100, new short[]{133,94,64}), STONE(1000, new short[]{139,139,139}), AIR(0,new short[]{0,0,0});

    int strength;
    short[] rgb;

    TileType(int strength, short[] rgb) {
        this.strength=strength;
        this.rgb=rgb;
    }

    public int getStrength() { return this.strength; }
    public short[] getRGB() { return this.rgb; }
}
