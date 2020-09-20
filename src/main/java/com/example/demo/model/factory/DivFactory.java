package com.example.demo.model.factory;

import com.example.demo.model.simplefactory.one.DivOperater;
import com.example.demo.model.simplefactory.one.Operator;

/**
 *  除法工厂
 */
public class DivFactory implements IFactory {
    @Override
    public Operator createOperator() {
        return new DivOperater();
    }
}
