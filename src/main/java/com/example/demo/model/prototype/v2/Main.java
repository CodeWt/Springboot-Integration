package com.example.demo.model.prototype.v2;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2  = (Person)p1.clone();
        System.out.println(p2);
        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "tj";
        System.out.println(p2.loc.street);
    }
}
