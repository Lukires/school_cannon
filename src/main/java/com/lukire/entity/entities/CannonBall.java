package com.lukire.entity.entities;

import com.lukire.entity.EntityShape;
import com.lukire.entity.Hitbox;
import com.lukire.entity.attributes.EntityExplosive;
import com.lukire.entity.types.Projectile;
import processing.core.PApplet;

public class CannonBall extends Projectile implements EntityExplosive {
    @Override
    public void draw(PApplet screen) {
        screen.fill(0,0,0);
        screen.rect(getX(),getY(),10,10);
    }

    @Override
    public float getElasticity() {
        return 0.0f;
    }

    @Override
    public Hitbox getHitbox() {
        return new Hitbox(EntityShape.SQUARE, 10, 10);
    }

    @Override
    public double getMass() {
        return 0;
    }

    @Override
    public float getBlastStrength() {
        return 1000.0f;
    }
}
