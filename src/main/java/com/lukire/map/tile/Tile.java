package com.lukire.map.tile;

public abstract class Tile {




    private float health = 100f;

    private TileType tile;
    public Tile(TileType tile) {
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


}
