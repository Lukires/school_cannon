package com.lukire.event.events;

import com.lukire.camera.Camera;
import com.lukire.event.Event;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class MouseMoveEvent extends Event {

    MouseEvent e;
    PApplet screen;
    final static Camera camera = Camera.getCamera();
    public MouseMoveEvent(MouseEvent e, PApplet screen) {
        this.e=e;
        this.screen=screen;
    }

    public MouseEvent getMouseEvent() {
        return this.e;
    }

    public float getX() {
        return (e.getX()-camera.getxOffset())/camera.getScale();
    }

    public float getY() {
        return (e.getY()+camera.getyOffset())/camera.getScale();
    }

    public PApplet getScreen() {
        return this.screen;
    }

}
