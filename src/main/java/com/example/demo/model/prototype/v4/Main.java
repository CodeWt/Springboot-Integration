package com.example.demo.model.prototype.v4;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p1.loc==p2.loc);
        System.out.println(p1.loc.street==p2.loc.street);
//        p1.loc.street = new StringBuilder("sh");

        //需要深克隆
        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
    }
}
