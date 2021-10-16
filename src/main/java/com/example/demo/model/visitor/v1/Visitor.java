package com.example.demo.model.visitor.v1;

/**
 *
 * 把变化的部分抽象
 *
 */
public abstract class Visitor {
    protected String name;
    protected double totalPrice;
    public Visitor(String name){
        this.name = name;
    }

    abstract double visitCpuPrice(ComputerPart computerPart);
    abstract double visitMemPrice(ComputerPart computerPart);
    abstract double visitBoardPrice(ComputerPart computerPart);
}
