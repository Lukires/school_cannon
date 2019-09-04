package com.lukire.event.listeners;

import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.ClickEvent;

public class ClickListener implements Listener {


    @EventListener
    public void onClick(ClickEvent e) {

        System.out.println("x: "+e.getX()+" y: "+e.getY());

    }
}
