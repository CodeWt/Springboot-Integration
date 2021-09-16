package com.example.demo.model.simplefactory.three;

public class Train implements Movable{
    @Override
    public void move() {
        System.out.println("train moving...");
    }
}
