package com.lukire.entity.attributes;

public interface EntityExplosive {

    default boolean blowOnImpact() {
        return true;
    }

    float getBlastStrength();
}
