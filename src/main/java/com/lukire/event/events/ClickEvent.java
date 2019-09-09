package com.lukire.event.events;

import com.lukire.camera.Camera;
import com.lukire.event.Event;
import processing.core.PApplet;
import processing.event.MouseEvent;


//Offset click coordinates from screen, to correspond with relative matrix transformation

public class ClickEvent extends Event {


    private MouseEvent mouseEvent;
    private static Camera camera = Camera.getCamera();
    PApplet screen;

    public ClickEvent(MouseEvent mouseEvent, PApplet screen) {
        this.mouseEvent=mouseEvent;
        this.screen=screen;
    }

    public MouseEvent getMouseEvent() { return mouseEvent; }

    //The coordinates are recalculated in accordance to the camera offset.
    public float getX() {
        return (mouseEvent.getX()-camera.getxOffset())/camera.getScale();
    }

    public float getY() {
        return (mouseEvent.getY()+camera.getyOffset())/camera.getScale();
    }

    public PApplet getScreen() {
        return this.screen;
    }

}
