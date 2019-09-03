package com.lukire.Map.Tile;

public abstract class MapTile {




    TileType tile;
    public MapTile(TileType tile) {
        this.tile=tile;
    }

    public TileType getTileType() {
        return tile;
    }


}
