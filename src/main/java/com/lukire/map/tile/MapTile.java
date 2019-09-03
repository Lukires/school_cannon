package com.lukire.map.tile;

public abstract class MapTile {




    private float health = 100f;

    private TileType tile;
    public MapTile(TileType tile) {
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
