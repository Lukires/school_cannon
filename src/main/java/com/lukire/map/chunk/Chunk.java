package com.lukire.map.chunk;

import com.lukire.map.tile.Tile;

public class Chunk {

    private Tile[][] tiles = new Tile[16][16];

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }

}
