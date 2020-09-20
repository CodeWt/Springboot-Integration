package com.example.demo.model.template;

/**
 *  实现父类的抽象方法以完成算法中与特定子类相关的步骤
 */
public class ConcreteClassA extends AbstractClass {
    @Override
    public void primitiveOperation_1() {
        //与具体类B不同的实现
        System.out.println("具体类A方法1的实现");
    }

    @Override
    public void primitiveOperation_2() {
        System.out.println("具体类A方法2的实现");
    }
}
