package com.lukire.event;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Event {
    public void trigger(Class<? extends Event> e) {
        ArrayList<Method> list = EventHandler.getListeners().get(e);
        if (list.isEmpty()) {
            return;
        }

        try{
            for (Method method : list) {
                method.invoke(e);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
