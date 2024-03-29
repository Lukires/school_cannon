package com.lukire.map.chunk;

import com.lukire.map.tile.NoTileException;
import com.lukire.map.tile.Tile;
import com.lukire.map.tile.tiles.AirTile;
import processing.core.PApplet;

public class Chunk {

    public Chunk() {
    }


    private static final int size = 16;
    public static int getSize() { return size; }

    private Tile[][] tiles = new Tile[16][16];


    //Gets the tile based on CHUNK TILE COORDINATES
    public Tile getTile(int x, int y) throws NoTileException {
        if (x >= 16 || y >= 16) {
            throw new NoTileException(x, y);
        }

        Tile tile = tiles[x][y];
        if (tile == null) {
            throw new NoTileException(x, y);
        }

        return tile;
    }

    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }

    //Gets the tile based on GAME COORDINATES
    public Tile getTileFromGameCoordinate(int x, int y) throws NoTileException {
        return getTile(getTileX(x), getTileY(y));
    }

    public void setTileFromGameCoordinate(int x, int y, Tile tile) {
        setTile(getTileX(x), getTileY(y), tile);
    }

    public int getTileX(int x) {
        return ((int)x/Tile.getSize())%Chunk.getSize();
    }

    public int getTileY(int y) {
        return ((int)y/Tile.getSize())%Chunk.getSize();
    }

    //xc and xy are CHUNK COORDINATES
    public void draw(PApplet screen, int xc, int xy) {
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                Tile tile = tiles[x][y];
                if (tile == null) {
                    continue;
                }

                //System.out.println(String.format("%s, %s", (xc*Chunk.getSize()+x*(Tile.getSize())),xy*Chunk.getSize()+y*Tile.getSize()));
                tile.draw(screen, (xc*Chunk.getSize()*Tile.getSize()+x*(Tile.getSize())),xy*Chunk.getSize()*Tile.getSize()+y*Tile.getSize());
            }
        }

    }

}
