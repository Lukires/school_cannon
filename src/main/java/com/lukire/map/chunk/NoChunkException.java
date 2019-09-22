package com.lukire.map.chunk;

public class NoChunkException extends Exception {
    private int x, y;
    public NoChunkException(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return String.format("NoChunkException at X:%s Y:%s", x, y);
    }
}

