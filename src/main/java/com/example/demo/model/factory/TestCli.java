package com.example.demo.model.factory;

import com.example.demo.exeception.MyException;
import com.example.demo.model.simplefactory.one.Operator;

/**
 * 工厂设计模式 test case
 */
public class TestCli {
    public static void main(String[] args) throws MyException {
        IFactory factory = new AddFactory();
        Operator operator = factory.createOperator();
        operator.setNumberA(5.0);
        operator.setNumberB(6);
        System.out.println(operator.getResult());
    }
}
