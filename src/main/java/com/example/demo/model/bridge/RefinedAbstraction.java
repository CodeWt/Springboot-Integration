package com.example.demo.model.bridge;

/**
 *  被提炼的抽象
 */
public class RefinedAbstraction extends Abstraction{
    @Override
    public void operation() {
        implementor.operation();
    }
}
