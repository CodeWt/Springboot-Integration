package com.example.demo.model.simplefactory.three;

public class Car implements Movable{
    @Override
    public void move() {
        System.out.println("car move...");
    }
}
