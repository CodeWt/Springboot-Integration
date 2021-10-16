package com.example.demo.model.spring.v1;

import java.util.Random;

public class Tank {
    public void move(){
        System.out.println("tank is moving.");
        try {
            Thread.sleep(new Random().nextInt(10*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fire(){
        System.out.println("tank is firing.");
        try {
            Thread.sleep(new Random().nextInt(10*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

