package com.example.demo.model.observe.code02;

public class PressEvent {
    long when;
    Button button;
    public PressEvent(){}

    public PressEvent(long when, Button button) {
        this.when = when;
        this.button = button;
    }
}
