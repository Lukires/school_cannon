package com.lukire.entity.entities;

import com.lukire.entity.Entity;
import com.lukire.entity.EntityCollision;
import com.lukire.entity.EntityShape;
import com.lukire.entity.Hitbox;
import processing.core.PApplet;

public class Cannon extends Entity implements EntityCollision {

    static final int size = 64;

    public void draw(PApplet screen) {
        screen.stroke(255,0,0);
        screen.fill(255,0,0);
        screen.rect(getX(),getY(),size, size);
    }

    @Override
    public double getMass() {
        return 1000.0;
    }

    @Override
    public Hitbox getHitbox() {
        return new Hitbox(EntityShape.SQUARE, size, size);
    }

    @Override
    public float getElasticity() {
        return 0.0f;
    }

}
