package com.example.demo.model.observe.code01;

public class DogObserver implements Observer{
    @Override
    public void actionOnEnvent(WakeUpEvent event) {
        if ("up".equals(event.eventName)){
            System.out.println("wang wang...");
        }
    }
}
