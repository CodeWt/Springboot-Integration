package com.example.demo.model.flyweight;

/**
 *  UnsharedConcreteFlyweight是指那些不需要共享的 Flyweight 子类。因为Flyweight 接口共享成为可能，但他并不强制共享。
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("不共享的具体 Flyweight ：" + extrinsicstate);
    }
}
