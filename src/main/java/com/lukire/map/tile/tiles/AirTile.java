package com.lukire.map.tile.tiles;

import com.lukire.map.tile.Tile;
import com.lukire.map.tile.TileType;

public class AirTile extends Tile {

    public AirTile(int x, int y) {
        super(TileType.AIR, x, y);
    }
}
