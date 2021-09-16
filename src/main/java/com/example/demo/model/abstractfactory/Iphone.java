package com.example.demo.model.abstractfactory;

public class Iphone extends PhoneBrand{
    public Iphone(String name) {
        super(name);
    }

    @Override
    void communicate() {
        System.out.println("I use " + this.name + " to say with you .");
    }
}
