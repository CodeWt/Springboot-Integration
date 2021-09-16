package com.example.demo.model.simplefactory.three;

public class Plane implements Movable{
    @Override
    public void move() {
        System.out.println("plane move is flying...");
    }
}
