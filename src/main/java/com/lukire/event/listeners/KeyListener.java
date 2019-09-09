package com.lukire.event.listeners;

import com.lukire.camera.Camera;
import com.lukire.event.EventListener;
import com.lukire.event.Listener;
import com.lukire.event.events.KeyPressEvent;
import processing.event.KeyEvent;

public class KeyListener implements Listener {


    Camera camera = Camera.getCamera();

    @EventListener
    public void onPress(KeyPressEvent e) {
        KeyEvent keyEvent = e.getKeyEvent();
        int key = keyEvent.getKeyCode();

        //LEFT
        if (key == 37) {
            camera.changeX(-10);
        }
        //RIGHT
        if (key == 39) {
            camera.changeX(10);
        }
        if (key == 38) {
            //camera.changeScale(0.1f);
            camera.changeY(-10);
        }

        if (key == 40) {
            camera.changeY(10);
        }

    }
}
