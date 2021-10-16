package com.example.demo.model.spring.v1;

public class LogProxy {
    public void before(){
        System.out.println("v1 before " + System.currentTimeMillis());
    }
    public void after(){
        System.out.println("v1 after " + System.currentTimeMillis());
    }
}
