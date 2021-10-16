package com.example.demo.model.spring.v2;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogProxy {

    @Before("execution(void com.example.demo.model.spring.v2.Tank.*())")
    public void before(){
        System.out.println("before v2 " + System.currentTimeMillis());
    }

    @After("execution(void com.example.demo.model.spring.v2.Tank.*())")
    public void after(){
        System.out.println("after v2 " + System.currentTimeMillis());
    }
}
