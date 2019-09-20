package com.lukire.entity;

public interface EntityCollision extends EntityPhysics {

    default boolean isCollideable() {
        return true;
    }

    float getElasticity();

    public Hitbox getHitbox();

    public double getMass();

    default boolean collides(float xOffset, float yOffset) {
        return getHitbox().isWithin(xOffset, yOffset);
    }
}
