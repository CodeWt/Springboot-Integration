package com.example.demo.thread.juc.c_020;

/**
 *
 * 锁的重入性
 *
 */
public class T01_ReentrantLock1 {
    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==1) m2();
        }
    }
    synchronized void m2(){
        System.out.println("m2.");
    }

    public static void main(String[] args) {
        T01_ReentrantLock1 t = new T01_ReentrantLock1();
        new Thread(t::m1).start();
//        new Thread(t::m2).start();
    }
}
