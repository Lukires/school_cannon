package com.lukire.event.events;

import com.lukire.event.Event;
import processing.core.PApplet;

public class NewFrameEvent extends Event {

    PApplet screen;
    public NewFrameEvent(PApplet screen) {
        this.screen=screen;
    }

    public PApplet getScreen() {
        return this.screen;
    }

}
