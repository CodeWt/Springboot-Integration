package com.example.demo.model.simplefactory.one;

public class SubOperater extends Operator {
    @Override
    public double getResult() {
        return this.getNumberA() - this.getNumberB();
    }
}
