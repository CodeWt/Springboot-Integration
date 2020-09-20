package com.example.demo.model.builder;

/**
 *  客户端调用，客户不需要知道具体的建造过程
 */
public class TestCli {
    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();
        director.directConstructProduct(b1);
        Product p1 = b1.getResult();
        p1.dis();
        director.directConstructProduct(b2);
        Product p2 = b2.getResult();
        p2.dis();

    }
}
