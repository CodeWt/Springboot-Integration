package com.example.demo.model.observe.code01;

import java.util.LinkedList;
import java.util.List;

public class Child {
    boolean cry = false;

    List<Observer> observers = new LinkedList<>();
    {
        observers.add(new DadObserver());
        observers.add(new DogObserver());
    }

    public void wakeUp(){
        cry = true;
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(),"up",this);
        for(Observer observer : observers){
            observer.actionOnEnvent(wakeUpEvent);
        }
    }

}
