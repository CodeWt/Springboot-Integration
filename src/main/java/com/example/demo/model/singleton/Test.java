package com.example.demo.model.singleton;

public class Test {
    public static void main(String[] args) {
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton01 singleton02 = Singleton01.getInstance();
        System.out.println(singleton01==singleton02);

        System.out.println("--------------");
        Singleton02 singleton021 = Singleton02.getInstance();
        Singleton02 singleton022 = Singleton02.getInstance();
        System.out.println(singleton021==singleton022);

        System.out.println("---------------");
    }
}
