package com.example.demo.model.visitor.v1;

public class Cpu extends ComputerPart{
    public Cpu(double price) {
        super(price);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitCpuPrice(this);
    }

}
