package com.example.demo.model.proxy.v1;

import java.util.Random;

/**
 *
 * 静态代理
 *
 */
public class StaticProxy {
    public static void main(String[] args) {
        Plane plane = new Plane();
        LogPlaneProxy logPlaneProxy = new LogPlaneProxy(plane);
        TimePlaneProxy timePlaneProxy = new TimePlaneProxy(logPlaneProxy);
        timePlaneProxy.move();
    }
}

interface Movable{
    void move();
}

class LogPlaneProxy implements Movable{
    Movable movable;
    public LogPlaneProxy(Movable movable){
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("Log start..");
        movable.move();
        System.out.println("Log end.");
    }
}

class TimePlaneProxy implements Movable{
    Movable movable;
    public TimePlaneProxy(Movable movable){
        this.movable = movable;
    }
    @Override
    public void move() {
//        System.out.println("计时开始");
        long start = System.currentTimeMillis();
        movable.move();
        System.out.println("用时：" + (System.currentTimeMillis() - start));
    }
}

class Plane implements Movable{

    @Override
    public void move() {
        System.out.println("fly ....");
        try {
            Thread.sleep(new Random().nextInt(10*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
