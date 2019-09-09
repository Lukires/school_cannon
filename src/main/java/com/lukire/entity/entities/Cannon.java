package com.lukire.entity.entities;

import com.lukire.entity.Collidable;
import com.lukire.entity.Entity;
import com.lukire.entity.Gravity;
import processing.core.PApplet;

public class Cannon extends Entity implements Collidable, Gravity {
    public void draw(PApplet screen) {
        screen.fill(255,0,0);
        screen.rect(getX(),getY(),getSize(),getSize());
    }

    public int getSize() {
        return 64;
    }
}
