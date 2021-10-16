package com.example.demo.model.visitor.v1;

public class Mem extends ComputerPart{
    public Mem(double price) {
        super(price);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitMemPrice(this);
    }

}
