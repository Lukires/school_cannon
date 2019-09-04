package com.lukire.map;

import com.lukire.map.chunk.Chunk;

import java.util.ArrayList;

public class Map {


    ArrayList<ArrayList<Chunk>> chunks = new ArrayList<ArrayList<Chunk>>();

    public void setChunk(int x, int y, Chunk chunk) {
        chunks.get(x).set(y, chunk);
    }


}
