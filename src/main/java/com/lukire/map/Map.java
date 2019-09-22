package com.lukire.map;

import com.lukire.map.chunk.Chunk;
import com.lukire.map.chunk.NoChunkException;
import com.lukire.map.tile.NoTileException;
import com.lukire.map.tile.Tile;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Map {

    HashMap<Integer, HashMap<Integer, Chunk>> chunks = new HashMap<Integer, HashMap<Integer, Chunk>>();

    //Set the chunk based on the CHUNK COORDINATES
    public void setChunk(int x, int y, Chunk chunk) {

        HashMap<Integer, Chunk> yChunks = chunks.get(x);
        if (yChunks == null) {
            yChunks = new HashMap<Integer, Chunk>();
        }

        yChunks.put(y, chunk);
        chunks.put(x, yChunks);
    }

    //Gets the chunk based on CHUNK COORDINATES
    public Chunk getChunk(int x, int y) throws NoChunkException {
        if (chunks.get(x) == null) {
            return new Chunk();
        }

        if (chunks.get(y) == null) {
            throw new NoChunkException(x, y);
        }

        return chunks.get(x).get(y);
    }


    //Gets the chunk based on GAME COORDINATES
    public Chunk getChunkFromGameLocation(int x, int y) throws NoChunkException {
        return getChunk(getChunkX(x), getChunkY(y));
    }

    public void setChunkFromGameLocation(int x, int y, Chunk chunk) {
        setChunk(getChunkX(x), getChunkY(y), chunk);
    }

    //Converts game coordinate to chunk coordinate
    public static int getChunkX(int x) {
        return (int)(x/(16*Tile.getSize()));
    }

    public static int getChunkY(int y) {
        return (int)(y/(16*Tile.getSize()));
    }

    public Tile getTile(int x, int y) throws NoChunkException, NoTileException {
        return getChunkFromGameLocation(x,y).getTileFromGameCoordinate(x,y);
    }

    public void setTile(Tile tile, int x, int y) throws NoChunkException, NoTileException {
        getChunkFromGameLocation(x,y).setTileFromGameCoordinate(x, y, tile);
    }


    /*

    This draw function finds all of the keys in the HashMap, for the x and y axis,
    it then proceeds to draw all of the chunks.

    The reason for this, instead of a simple loop, is that the x and y axis do not necessarily start at 0
    The KeySet could start at ANY number. Which is why we use iterators to loop through it instead.

     */

    public void updateChunk(PApplet screen, int x, int y) throws NoChunkException{
        Chunk chunk = getChunkFromGameLocation(x, y);

        if (chunk != null) {
            chunk.draw(screen, getChunkX(x), getChunkY(y));
        }
    }

    public void updateNearbyChunks(PApplet screen, int x, int y, int chunkDistance) {
        for (int i = 0; i < chunkDistance; i++) {
            try{
                //We update the same chunk twice at i=0, but who really cares about that
                updateChunk(screen, x+16*chunkDistance, y+16*chunkDistance);
                updateChunk(screen, x-16*chunkDistance, y-16*chunkDistance);
            }catch(NoChunkException e) {
                continue;
            }
        }
    }


    public void draw(PApplet screen) {

        Set<Integer> xs = chunks.keySet();
        for (Integer x : xs) {
            Set<Integer> ys = chunks.get(x).keySet();
            for (Integer y : ys) {
                HashMap<Integer, Chunk> yChunks = chunks.get(x);
                if (yChunks == null) {
                    continue;
                }
                Chunk chunk = yChunks.get(y);
                chunk.draw(screen, x, y);
                //System.out.println(String.format("{{%s, %s}}", x, y));
            }
        }

    }

}
