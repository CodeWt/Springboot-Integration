package com.example.demo.model.simplefactory.one;

public class MulOperater extends Operator {
    @Override
    public double getResult() {
        return this.getNumberA() * this.getNumberB();
    }
}
