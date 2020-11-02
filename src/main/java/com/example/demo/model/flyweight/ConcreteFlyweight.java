package com.example.demo.model.flyweight;

/**
 *  ConcreteFlyweight 是继承 Flyweight的 类并实现其接口，并为内部状态增加存储空间。
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("具体的 Flyweight ： " + extrinsicstate);
    }
}
