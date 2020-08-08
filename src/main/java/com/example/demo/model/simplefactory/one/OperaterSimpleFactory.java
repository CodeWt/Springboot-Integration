package com.example.demo.model.simplefactory.one;

public class OperaterSimpleFactory {
    public static Operator createOperater(String operater){
        Operator operator = null;
        switch (operater){
            case "+":
                operator = new AddOperater();
                break;
            case "-":
                operator = new SubOperater();
                break;
            case "*":
                operator = new MulOperater();
                break;
            case "/":
                operator = new DivOperater();
        }
        return operator;
    }
}
