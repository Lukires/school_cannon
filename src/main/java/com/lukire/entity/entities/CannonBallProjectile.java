package com.lukire.entity.entities;

import processing.core.PApplet;

public class CannonBallProjectile extends Projectile {
    public void draw(PApplet screen) {

        screen.fill(0, 255, 0);
    }

    public int getSize() {
        return 16;
    }
}
