package com.example.demo.model.visitor.v1;

public abstract class ComputerPart {
    protected double price;

    public ComputerPart(double price) {
        this.price = price;
    }
    abstract void accept(Visitor visitor);

}

