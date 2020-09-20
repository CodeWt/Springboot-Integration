package com.example.demo.model.factory;

import com.example.demo.model.simplefactory.one.AddOperater;
import com.example.demo.model.simplefactory.one.Operator;

/**
 * 加法工厂
 */
public class AddFactory implements IFactory {
    @Override
    public Operator createOperator() {
        return new AddOperater();
    }
}
