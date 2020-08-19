package com.example.demo.model.decorator.two;

public class Tshirts extends Finery {
    @Override
    public void show() {
        System.out.println("big T shirt.");
        super.show();
    }
}