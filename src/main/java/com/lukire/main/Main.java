package com.lukire.main;

import processing.core.PApplet;

public class Main extends PApplet {

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
        rect(0,0,4,4);
    }

}
