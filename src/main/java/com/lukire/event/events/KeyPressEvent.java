package com.lukire.event.events;

import com.lukire.event.Event;
import processing.event.KeyEvent;

public class KeyPressEvent extends Event {


    KeyEvent keyEvent;
    public KeyPressEvent(KeyEvent e) {
        this.keyEvent=e;
    }

    public KeyEvent getKeyEvent() {
        return this.keyEvent;
    }
}
