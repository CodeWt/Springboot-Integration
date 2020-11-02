package com.example.demo.model.visitor;

/**
 *  ConcreteVisitorA 和 ConcreteVisitorB 类， 具体访问者，实现每个由Visitor声明的操作。每个操作实现算法的一部分，而该算法片段乃是对应于结构中对象的类。
 */
public class ConcreteVisitorA extends Visitor {
    @Override
    public void visitConcreteElementX(ConcreteElementX concreteElementX) {
        System.out.println(concreteElementX.getClass().getSimpleName() + " 被 " + this.getClass().getSimpleName() + "访问" );
    }

    @Override
    public void visitConcreteElementY(ConcreteElementY concreteElementY) {
        System.out.println(concreteElementY.getClass().getSimpleName() + " 被 " + this.getClass().getSimpleName() + "访问");
    }
}
