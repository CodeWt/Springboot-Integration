package com.example.demo.model.bridge;

/**
 *  具体的实现
 */
public class ConcreteImplementorA extends Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现A的方法执行");
    }
}
