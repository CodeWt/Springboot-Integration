package com.example.demo.model.visitor.v1;

public class PersonVisitor extends Visitor {
    public PersonVisitor(String name) {
        super(name);
    }

    @Override
    double visitCpuPrice(ComputerPart computerPart) {
        return this.totalPrice += computerPart.price * 0.5;
    }

    @Override
    double visitMemPrice(ComputerPart computerPart) {
        return this.totalPrice += computerPart.price * 0.5;
    }

    @Override
    double visitBoardPrice(ComputerPart computerPart) {
        return this.totalPrice += computerPart.price * 0.5;
    }
}
