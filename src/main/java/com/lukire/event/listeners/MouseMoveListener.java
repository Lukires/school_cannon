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
            screen.pushMatrix();
            screen.translate(entity.getX()+entity.getSize()/2,entity.getY());
            screen.rotate((float)Math.atan((entity.getY()-e.getY())/(entity.getX()-e.getX())));
            screen.fill(0, 0, 255);
            screen.rect(0, 0, entity.getSize(), entity.getSize()/2);
            screen.popMatrix();

        }
    }
}
