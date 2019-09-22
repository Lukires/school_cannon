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

    private static HashMap<Class<? extends Event>, ArrayList<Method>> methods = new HashMap<Class<? extends Event>, ArrayList<Method>>();
    private static HashMap<Method, Listener> listeners = new HashMap<Method, Listener>();

    private static void addListener(Class<? extends Event> event, Method method, Listener listener) {
        ArrayList<Method> list = methods.get(event) == null? new ArrayList<Method>():methods.get(event);
        list.add(method);
        methods.put(event, list);
        listeners.put(method, listener);
    }

    public static void register(Listener listener) {
        Class<?> cl = listener.getClass();

        Method[] methods = cl.getMethods();

        for (Method method : methods) {

            for (Annotation annotation : method.getDeclaredAnnotations()) {

                if (annotation instanceof EventListener) {
                    //We're only interested in the first parameter!
                    if (method.getParameterCount()>1) {
                        //throw error
                        return;
                    }
                    Parameter parameter = method.getParameters()[0];

                    if (parameter.getType().getSuperclass().equals(Event.class)) {
                        addListener((Class<? extends Event>) parameter.getType(), method, listener);
                    }
                }
            }
        }

    }

    public static HashMap<Class<? extends Event>, ArrayList<Method>> getListeners() {
        return methods;
    }

    public static void trigger(Event e) {

        ArrayList<Method> list = EventHandler.getListeners().get(e.getClass());
        if (list == null) {
            return;
        }

        try{
            for (Method method : list) {
                method.invoke(listeners.get(method), e);
            }
        }catch(Exception ex) {
            //ex.printStackTrace();
        }
    }
}
