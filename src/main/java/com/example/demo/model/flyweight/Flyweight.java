package com.example.demo.model.flyweight;

/**
 *  所有具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态
 */
public abstract class Flyweight {
    public abstract void operation(int extrinsicstate);
}
