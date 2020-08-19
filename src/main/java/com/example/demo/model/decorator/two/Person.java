package com.example.demo.model.decorator.two;

/**
 * ConcreteComponent
 */
public class Person {
    private String name;
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("被装扮的是 ： " + name);
    }
}
