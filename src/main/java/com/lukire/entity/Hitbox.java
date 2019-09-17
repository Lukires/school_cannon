package com.lukire.entity;

public class Hitbox {


    int a, b;
    EntityShape entityShape;

    //Designed for SQUARES
    public Hitbox(EntityShape entityShape, int a, int b) {
        this.entityShape=entityShape;
        this.a=a;
        this.b=b;
    }


    //offsetX is the x coordinate minus the entity's x coordinate
    //offsetY is the y coordinate minus the entity's y coordinate
    public boolean isWithin(float offsetX, float offsetY) {

        switch(this.entityShape) {
            case ELLIPSE:

                double angle = Math.tan(offsetY / offsetY);
                double localX = Math.cos(angle)*a;
                double localY = Math.sin(angle)*b;

                return offsetX <= localX && offsetY <= localY;

            case SQUARE:
                return (offsetX<=a && offsetY<=b) && (offsetX>=0 && offsetY>=0);
        }
        return false;
    }

    public int getWidth() {
        return a;
    }

    public int getHeight() {
        return b;
    }

    public EntityShape getEntityShape() {
        return this.entityShape;
    }

    //Designed for CIRCLES
}
