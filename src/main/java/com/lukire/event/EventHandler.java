package com.lukire.event;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;

public class EventHandler {

    private static EventHandler instance = new EventHandler();

    public static EventHandler getHandler() {
        return instance;
    }


    private EventHandler() {

    }

    private static HashMap<Class<? extends Event>, ArrayList<Method>> listeners = new HashMap<Class<? extends Event>, ArrayList<Method>>();


    private static void addListener(Class<Event> event, Method listener) {
        ArrayList<Method> list = listeners.get(event).isEmpty()? new ArrayList<Method>():listeners.get(event);
        list.add(listener);
        listeners.put(event, list);
    }

    public static void register(Listener listener) {

        Class cl = listener.getClass();

        Method[] methods = cl.getMethods();

        for (Method method : methods) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {

                if (annotation.getClass().equals(EventListener.class)) {

                    //We're only interested in the first parameter!
                    if (method.getParameterCount()>1) {
                        //throw error
                        return;
                    }
                    Parameter parameter = method.getParameters()[0];
                    if (parameter.getType().isAssignableFrom(Event.class)) {

                        //CHANGE EVENT SO IT'S NOT EVENT.CLASS, SO THE CHILD OF EVENT.CLASS IS THROWN.
                        addListener((Class<Event>) parameter.getType(), method);
                    }
                }
            }
        }

    }

    public static HashMap<Class<? extends Event>, ArrayList<Method>> getListeners() {
        return listeners;
    }




}
