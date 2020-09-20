package com.example.demo.model.factory;

import com.example.demo.model.simplefactory.one.Operator;
import com.example.demo.model.simplefactory.one.SubOperater;

/**
 * 减法工厂
 */
public class SubFactory implements IFactory{
    @Override
    public Operator createOperator() {
        return new SubOperater();
    }
}
