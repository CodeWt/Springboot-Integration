package com.example.demo.model.template.code1015;

public class Main {
    public static void main(String[] args) {
        TemplateClass t = new ConcreteImpl();
        t.templateMethod();
    }
}
abstract class TemplateClass{
    public void templateMethod(){
        m1();
        m2();
    }

    abstract void m1();
    abstract void m2();
}

class ConcreteImpl extends TemplateClass{

    @Override
    void m1() {
        System.out.println("m1.");
    }

    @Override
    void m2() {
        System.out.println("m2.");
    }
}
