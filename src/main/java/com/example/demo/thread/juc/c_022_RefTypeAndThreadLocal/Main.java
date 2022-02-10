package com.example.demo.thread.juc.c_022_RefTypeAndThreadLocal;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Person p = new Person();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            p.name="wt";
        }).start();
    }
}
class Person{
    String name = "zt";
}
