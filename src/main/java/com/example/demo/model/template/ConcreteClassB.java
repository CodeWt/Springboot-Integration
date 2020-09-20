package com.example.demo.model.template;

public class ConcreteClassB extends AbstractClass{
    @Override
    public void primitiveOperation_1() {
        //与具体类A不同的实现
        System.out.println("具体类B方法1的实现");
    }

    @Override
    public void primitiveOperation_2() {
        System.out.println("具体类B方法2的实现");
    }
}
