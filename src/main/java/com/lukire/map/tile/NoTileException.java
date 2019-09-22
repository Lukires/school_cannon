package com.lukire.map.tile;

public class NoTileException extends Exception {

    private int x, y;
    public NoTileException(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return String.format("NoTileException at X:%s Y:%s", x, y);
    }
}
