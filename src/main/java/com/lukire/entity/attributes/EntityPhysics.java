package com.lukire.entity.attributes;

public interface EntityPhysics {

    static final double GRAVITATIONAL_CONSTANT = 1.0;

    default boolean affectedByGravity() {
        return true;
    }

}
