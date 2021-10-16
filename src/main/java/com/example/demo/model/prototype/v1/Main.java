package com.example.demo.model.prototype.v1;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p2);

        System.out.println(p1.loc = p2.loc);
        p1.loc.street="sh";
        System.out.println(p2.loc.street);

    }
}
