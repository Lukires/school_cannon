package com.lukire.main;

import com.lukire.camera.Camera;
import com.lukire.entity.Entity;
import com.lukire.entity.Placement;
import com.lukire.entity.entities.Cannon;
import com.lukire.event.EventHandler;
import com.lukire.event.events.ClickEvent;
import com.lukire.event.events.KeyPressEvent;
import com.lukire.event.events.MouseMoveEvent;
import com.lukire.event.events.NewFrameEvent;
import com.lukire.event.listeners.*;
import com.lukire.map.Map;
import com.lukire.map.MapGeneration;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class Main extends PApplet {


    Camera camera = Camera.getCamera();
    int cameraX;
    int cameraY;
    Map map = MapGeneration.generateMap();
    public static boolean update = true;
    public NewFrameEvent newFrameEvent;
    public static void main(String[] args) {
        Main.main("com.lukire.main.Main");
    }


    @Override
    public void settings() {

        size(1000,1000);
    }

    @Override
    public void setup() {
        frameRate(30);

        EventHandler.register(new ClickListener());
        EventHandler.register(new KeyListener());
        EventHandler.register(new PhysicsListener());
        EventHandler.register(new EntityBlockCollisionListener());
        EventHandler.register(new MouseMoveListener());

        Entity.spawn(new Cannon(), new Placement(map, 100,100));

        newFrameEvent = new NewFrameEvent(this, frameCount, (int) frameRate);
    }

    @Override
    public void draw() {

        //map.draw(this);
        EventHandler.trigger(newFrameEvent);
        if (camera.getxOffset() != cameraX || camera.getyOffset() != cameraY) {
            update=true;
        }

        if (update) {
            clear();
            setMatrix(camera);
            map.draw(this);

            update=!update;
        }

        for (Entity entity : Entity.getEntities()) {
            entity.draw(this);
        }

    }

    public void keyPressed(KeyEvent e) {
        EventHandler.trigger(new KeyPressEvent(e));

    }

    public void mousePressed(MouseEvent e) {
        EventHandler.trigger(new ClickEvent(e, this));
    }

    public void mouseMoved(MouseEvent e) {
        EventHandler.trigger(new MouseMoveEvent(e, this));
    }
}
