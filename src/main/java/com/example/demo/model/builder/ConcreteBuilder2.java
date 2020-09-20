package com.example.demo.model.builder;
/**
 *  具体建造类 ConcreteBuilder2
 */
public class ConcreteBuilder2 extends Builder {
    private Product product = new Product();
    /**
     *  建造两个具体的部件 X 和 Y
     */
    @Override
    public void buildPartA() {
        product.addPart("部件X");
    }

    @Override
    public void buildPartB() {
        product.addPart("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
