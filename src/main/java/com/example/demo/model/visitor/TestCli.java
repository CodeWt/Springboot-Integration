package com.example.demo.model.visitor;

public class TestCli {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new ConcreteElementX());
        o.attach(new ConcreteElementY());

        ConcreteVisitorA visitorA = new ConcreteVisitorA();
        ConcreteVisitorB visitorB = new ConcreteVisitorB();

        o.accept(visitorA);
        o.accept(visitorB);
    }
}
