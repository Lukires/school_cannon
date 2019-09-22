package com.lukire.entity.attributes;

import com.lukire.entity.Entity;

public interface EntityExplosive {

    default boolean blowOnImpact() {
        return true;
    }

    float getBlastStrength();

    default void explode() {

    }
}
