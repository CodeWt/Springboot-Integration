package com.example.demo.model.proxy.two;

public class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("真实的请求 。");
    }
}
