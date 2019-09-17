package com.lukire.event.events;

import com.lukire.event.Event;
import processing.core.PApplet;

public class NewFrameEvent extends Event {

    PApplet screen;
    int frameCount, fps;
    double secondPerFrame;

    public NewFrameEvent(PApplet screen, int frameCount, int fps) {
        this.screen=screen;
        this.frameCount=frameCount;
        this.fps=fps;
        this.secondPerFrame = 1.0/(double)fps;
    }

    public PApplet getScreen() {
        return this.screen;
    }

    public int getFrameCount() { return this.frameCount;}
    public int getFps() { return this.fps; }
    public double getSecondPerFrame() { return this.secondPerFrame; }
}
