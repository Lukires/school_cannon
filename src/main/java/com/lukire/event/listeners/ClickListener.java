package com.lukire.event.listeners;

import com.lukire.entity.Entity;
import com.lukire.entity.entities.Cannon;
import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.ClickEvent;

public class ClickListener implements Listener {


    @EventListener
    public void onClick(ClickEvent e) {
        for (Entity entity : Entity.getEntities()) {
            if (!(entity instanceof Cannon)) {
                return;
            }

            ((Cannon) entity).shootCannonBall();
        }

    }
}
