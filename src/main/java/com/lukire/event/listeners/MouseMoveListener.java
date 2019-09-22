package com.lukire.event.listeners;

import com.lukire.entity.Entity;
import com.lukire.entity.entities.Cannon;
import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.MouseMoveEvent;
import processing.core.PApplet;

public class MouseMoveListener implements Listener {

    @EventListener
    public void onMove(MouseMoveEvent e) {

        PApplet screen = e.getScreen();

        for (Entity entity : Entity.getEntities()) {
            if (!(entity instanceof Cannon)) {
                return;
            }

            ((Cannon) entity).setAngle((float)Math.atan(((e.getY()-entity.getY())/(e.getX()-entity.getX()))));
        }
    }
}
