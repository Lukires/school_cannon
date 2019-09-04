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
        System.out.println(7);
        ArrayList<Method> list = methods.get(event) == null? new ArrayList<Method>():methods.get(event);
        System.out.println(8);
        list.add(method);
        System.out.println(9);
        System.out.println(event.toString() +" "+ list.toString());
        methods.put(event, list);
        listeners.put(method, listener);
    }

    public static void register(Listener listener) {
        Class<?> cl = listener.getClass();

        Method[] methods = cl.getMethods();

        for (Method method : methods) {

            for (Annotation annotation : method.getDeclaredAnnotations()) {

                System.out.println(annotation.toString());
                System.out.println(3);
                if (annotation instanceof EventListener) {
                    System.out.println(4);
                    //We're only interested in the first parameter!
                    if (method.getParameterCount()>1) {
                        //throw error
                        return;
                    }
                    System.out.println(5);

                    System.out.println(method.getParameterTypes());
                    Parameter parameter = method.getParameters()[0];

                    System.out.println(parameter.getType().getSuperclass().equals(Event.class));
                    if (parameter.getType().getSuperclass().equals(Event.class)) {
                        System.out.println(6);
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

        System.out.println(getListeners().toString());
        ArrayList<Method> list = EventHandler.getListeners().get(e.getClass());
        if (list == null) {
            return;
        }

        System.out.println(20);

        try{
            for (Method method : list) {
                System.out.println(method.toString());
                System.out.println(e.toString());
                method.invoke(listeners.get(method), e);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
