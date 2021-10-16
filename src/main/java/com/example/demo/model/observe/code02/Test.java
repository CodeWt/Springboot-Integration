package com.example.demo.model.observe.code02;

public class Test {
    public static void main(String[] args) {
        Button button = new Button();
        button.addListener(new Listener1());
        button.addListener(new Listener2());
        button.pressButton();
    }
}
