package com.example.demo.model.visitor;

public class ConcreteVisitorB extends Visitor {
    @Override
    public void visitConcreteElementX(ConcreteElementX concreteElementX) {
        System.out.println(concreteElementX.getClass().getSimpleName() + " 被 " + this.getClass().getSimpleName() + " 访问 ");
    }

    @Override
    public void visitConcreteElementY(ConcreteElementY concreteElementY) {
        System.out.println(concreteElementY.getClass().getSimpleName() + " 被 " + this.getClass().getSimpleName() + " 访问 ");
    }
}
