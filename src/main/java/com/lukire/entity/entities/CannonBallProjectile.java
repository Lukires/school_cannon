package com.lukire.entity.entities;

import processing.core.PApplet;

public class CannonBallProjectile extends Projectile {
    public void draw(PApplet screen) {

        screen.fill(255,0,0);
        screen.rect(x,y,64,64);

    }
}
