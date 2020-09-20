package com.example.demo.model.factory;

import com.example.demo.model.simplefactory.one.MulOperater;
import com.example.demo.model.simplefactory.one.Operator;

/**
 * 乘法工厂
 */
public class MulFactory implements IFactory {
    @Override
    public Operator createOperator() {
        return new MulOperater();
    }
}
