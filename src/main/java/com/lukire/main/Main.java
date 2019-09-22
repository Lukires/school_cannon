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

import java.util.ArrayList;

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
    public static int points = 0;


    @Override
    public void settings() {

        size(1500,1000);
    }

    @Override
    public void setup() {
        frameRate(120);

        EventHandler.register(new ClickListener());
        EventHandler.register(new KeyListener());
        EventHandler.register(new PhysicsListener());
        EventHandler.register(new EntityBlockCollisionListener());
        EventHandler.register(new MouseMoveListener());

        Entity.spawn(new Cannon(), new Placement(map, 16,96));

        newFrameEvent = new NewFrameEvent(this, frameCount, (int) frameRate);
    }

    @Override
    public void draw() {

        if (points >= 600) {

            color(0,0,0);
            textSize(40);
            println("Victory!");
            points = 0;
            map = MapGeneration.generateMap();

            ArrayList<Entity> removing = new ArrayList<Entity>();

            for (Entity entity : Entity.getEntities()) {
                if (entity instanceof Cannon) {
                    entity.setMap(map);
                }else{
                    removing.add(entity);
                }
            }

            for (Entity entity : removing) {
                Entity.remove(entity);
            }

        }

        map.draw(this);
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
            //map.updateNearbyChunks(this, (int)entity.getX(), (int)entity.getY(), 8);
            entity.draw(this);
        }

        color(0,0,0);
        textSize(30);
        text("Points earned: "+points, 60,60);

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
