package com.example.demo.model.simplefactory.one;

import com.example.demo.exeception.MyException;

public class Operator {
    private double numberA;
    private double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
    public double getResult() throws MyException {
        double result = 0.0;
        return result;
    }
}
