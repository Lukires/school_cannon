package com.lukire.main;

import com.lukire.camera.Camera;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends PApplet {


    Camera camera = Camera.getCamera();


    public static void main(String[] args) {
        Main.main("com.lukire.main.Main");
    }


    @Override
    public void settings() {
        size(1000,1000);
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {
        clear();
        setMatrix(camera);
        rect(100,100,20,20);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        //LEFT
        if (key == 37) {
            camera.changeX(-10);
        }

        //RIGHT
        if (key == 39) {
            camera.changeX(10);
        }


        if (key == 38) {
            camera.changeScale(0.1f);
        }

        if (key == 40) {
            camera.changeScale(-0.1f);
        }

    }

}
