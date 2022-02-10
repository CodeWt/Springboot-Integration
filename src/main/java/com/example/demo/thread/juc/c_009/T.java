package com.example.demo.thread.juc.c_009;

/**
 *
 * 可重入锁
 *
 */
public class T {
    synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start.");
        m2();
        System.out.println(Thread.currentThread().getName() + " m1 end.");
    }
    synchronized void m2(){
        System.out.println(Thread.currentThread().getName() + " m2 start.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end.");
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        new Thread(t::m1).start();
    }
}
