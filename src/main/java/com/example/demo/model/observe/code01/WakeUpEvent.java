package com.example.demo.model.observe.code01;


public class WakeUpEvent extends Event<Child>{
    long timestamp;
    String eventName;
    Child child;
    public WakeUpEvent(){}
    public WakeUpEvent(long timestamp, String eventName, Child child) {
        this.timestamp = timestamp;
        this.eventName = eventName;
        this.child = child;
    }

    @Override
    Child getSource() {
        return child;
    }
}
