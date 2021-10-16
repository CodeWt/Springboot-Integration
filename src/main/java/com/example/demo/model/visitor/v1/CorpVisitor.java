package com.example.demo.model.visitor.v1;

public class CorpVisitor extends Visitor{
    public CorpVisitor(String name) {
        super(name);
    }

    @Override
    double visitCpuPrice(ComputerPart computerPart) {
        return this.totalPrice += computerPart.price * 0.9;
    }

    @Override
    double visitMemPrice(ComputerPart computerPart) {
        return this.totalPrice += computerPart.price * 0.9;
    }

    @Override
    double visitBoardPrice(ComputerPart computerPart) {
        return this.totalPrice += computerPart.price * 0.9;
    }
}
