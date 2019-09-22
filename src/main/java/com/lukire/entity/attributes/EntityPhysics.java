package com.lukire.entity.attributes;

public interface EntityPhysics {

    static final double GRAVITATIONAL_CONSTANT = 3.0;

    default boolean affectedByGravity() {
        return true;
    }

}
