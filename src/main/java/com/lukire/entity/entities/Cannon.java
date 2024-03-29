package com.lukire.entity.entities;

import com.lukire.entity.Entity;
import com.lukire.entity.Placement;
import com.lukire.entity.attributes.EntityCollision;
import com.lukire.entity.EntityShape;
import com.lukire.entity.Hitbox;
import processing.core.PApplet;
import processing.core.PVector;

public class Cannon extends Entity implements EntityCollision {

    static final int size = 64;
    float angle = 45f;

    public void draw(PApplet screen) {
        screen.stroke(255,0,0);
        screen.fill(255,0,0);
        screen.rect(getX(),getY(),size, size);

        screen.stroke(0,255,0);
        screen.fill(0,0,0);
        screen.pushMatrix();


        //screen.rect(getX()+size, getY(), size/2, size/2);
        screen.translate(getX()+size, getY());
        screen.rotate(angle);
        screen.rect(0, 0, size, size/2);

        screen.popMatrix();
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

    public void shootCannonBall() {
        CannonBall cb = new CannonBall();
        Entity.spawn(cb, new Placement(this.getPlacement().getMap(), this.getPlacement().getX()+size, this.getPlacement().getY()+size/4));
        cb.getPlacement().setDirection(new PVector((float)(20*Math.cos((angle))), (float)(20*Math.sin(angle))));
        
    }

    public void setAngle(float angle) {
        this.angle=angle;
    }

}
