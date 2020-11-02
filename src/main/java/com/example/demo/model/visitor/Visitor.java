package com.example.demo.model.visitor;

/**
 *  为该对象结构中ConcreteElement的每一个类声明一个visit操作。
 */
public abstract class Visitor {
    public abstract void visitConcreteElementX(ConcreteElementX concreteElementX);
    public abstract void visitConcreteElementY(ConcreteElementY concreteElementY);
}
