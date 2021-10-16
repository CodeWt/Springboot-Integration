package com.example.demo.model.observe.code02;

import java.util.ArrayList;
import java.util.List;

public class Button {
    List<Listener> listeners = new ArrayList<>();
    void addListener(Listener listener){
        listeners.add(listener);
    }
    void pressButton(){
        PressEvent pressEvent = new PressEvent(System.currentTimeMillis(), this);
        for (Listener listener : listeners){
            listener.actionAfterPress(pressEvent);
        }
    }
}
