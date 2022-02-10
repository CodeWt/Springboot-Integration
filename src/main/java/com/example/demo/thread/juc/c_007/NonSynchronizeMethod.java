package com.example.demo.thread.juc.c_007;

public class NonSynchronizeMethod {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " start.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end .");
    }
    public void m2(){
        System.out.println(Thread.currentThread().getName() + " start.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end.");
    }

    public static void main(String[] args) {
        NonSynchronizeMethod t = new NonSynchronizeMethod();
        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();
    }
}
