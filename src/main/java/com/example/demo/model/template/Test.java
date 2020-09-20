package com.example.demo.model.template;

public class Test {
    public static void main(String[] args) {
        AbstractClass c;
        c = new ConcreteClassA();
        c.templateMethod();
        System.out.println("-------split line--------");
        c = new ConcreteClassB();
        c.templateMethod();
    }
}
