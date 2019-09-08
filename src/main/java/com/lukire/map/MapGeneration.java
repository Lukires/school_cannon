package com.lukire.map;

//Random world generation

import com.lukire.map.chunk.Chunk;
import com.lukire.map.tile.Tile;
import com.lukire.map.tile.TileType;
import com.lukire.map.tile.tiles.AirTile;
import com.lukire.map.tile.tiles.DirtTile;
import com.lukire.map.tile.tiles.StoneTile;

public class MapGeneration {

    public static Map generateMap() {

        Map map = new Map();

        for(int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Chunk chunk = new Chunk();
                for (int xt = 0; xt < 16; xt++) {
                    for (int yt = 0; yt < 16; yt++) {
                        if (y < 4) {
                            chunk.setTile(xt, yt, new AirTile());
                        }else {
                            if ((xt * yt) %2 == 0) {
                                chunk.setTile(xt, yt, new DirtTile());
                            }else{
                                chunk.setTile(xt, yt, new StoneTile());
                            }
                            //System.out.println(String.format("%s, %s, %s, %s", x,y, xt, yt));
                        }
                    }
                }
                map.setChunk(x, y, chunk);
            }

        }

        return map;
    }

}