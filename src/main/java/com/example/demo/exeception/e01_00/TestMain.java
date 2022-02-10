package com.example.demo.exeception.e01_00;

public class TestMain {
    public static void main(String[] args) {
        A a = new A(()->{
            System.out.println("呵呵。。");
        });
        try {
            System.out.println(a.m1(1,0));
            System.out.println(a.m1(3,2));
            System.out.println("---------------");
        } catch (ZeroException e) {
            e.printStackTrace();
        }

        new ITest(){
            @Override
            public void m1(){
                System.out.println("test interface");
            }
        }.m1();

    }
}
