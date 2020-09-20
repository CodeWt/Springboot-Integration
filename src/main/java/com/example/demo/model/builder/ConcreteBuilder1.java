package com.example.demo.model.builder;

/**
 *  具体建造类 ConcreteBuilder1
 */
public class ConcreteBuilder1 extends Builder {
    private Product product = new Product();

    /**
     *  建造两个具体的部件 A 和 B
     */
    @Override
    public void buildPartA() {
        product.addPart("部件A");
    }

    @Override
    public void buildPartB() {
        product.addPart("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
