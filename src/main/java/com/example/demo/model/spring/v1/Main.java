package com.example.demo.model.spring.v1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = (Tank)context.getBean("tank");
        tank.move();
        tank.fire();
    }
}
