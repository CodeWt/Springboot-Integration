package com.example.demo.model.flyweight;

/**
 *
 */
public class TestCli {
    public static void main(String[] args) {
        //代码的外部状态
        int extrinsicstate = 22;

        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fx = factory.getFlyWeight("X");
        fx.operation(--extrinsicstate);

        Flyweight fy = factory.getFlyWeight("Y");
        fy.operation(--extrinsicstate);

        Flyweight fz = factory.getFlyWeight("Z");
        fz.operation(--extrinsicstate);

        Flyweight uf = new UnsharedConcreteFlyweight();
        uf.operation(--extrinsicstate);
    }
}
