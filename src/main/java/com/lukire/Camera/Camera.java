package com.lukire.Camera;

import processing.core.PMatrix2D;

public class Camera extends PMatrix2D {

    private static Camera cameraInstance = new Camera();

    public static Camera getCamera() {
        return cameraInstance;
    }

    private Camera() {

    }

    private float scale = 1;
    private int xOffset = 0;
    private int yOffset = 0;
    private float angleOffset = 0;

    public float getScale() {
        return this.scale;
    }

    public int getxOffset() {
        return this.xOffset;
    }

    public int getyOffset() {
        return this.yOffset;
    }

    public float getAngleOffset() { return this.angleOffset; }

    public void changeScale(float scale) {
        this.scale+=scale;
        scale(this.scale);

    }

    public void changeX(int x) {
        this.xOffset+=x;
        translate(x,0);
    }

    public void changeY(int y){
        this.yOffset+=y;
        translate(0,y);
    }

    public void rotate(float angle) {
        this.angleOffset+=angle;
        super.rotate(angle);
    }

}