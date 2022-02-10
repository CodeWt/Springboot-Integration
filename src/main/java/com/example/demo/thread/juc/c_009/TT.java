package com.example.demo.thread.juc.c_009;

/**
 *
 *
 * 可重入锁 ，2次都是锁的this对象，即子类对象
 *
 *
 */
public class TT {
    synchronized void m(){
        System.out.println("parent m()");
    }

    public static void main(String[] args) {
//        TT tt = new Child();
//        new Thread(tt::m).start();
        Child child = new Child();
        new Thread(child::m).start();
    }
}
class Child extends TT{
    @Override
    synchronized void m() {
        super.m();
        System.out.println("child m()");
    }
}
