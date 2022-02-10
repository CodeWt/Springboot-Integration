package com.example.demo.thread.juc.c_020;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T02_ReentrantLock2 {
    Lock lock = new ReentrantLock();
    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
    }
    void m2(){
        try {
            lock.lock();
            System.out.println("m2");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T02_ReentrantLock2 t = new T02_ReentrantLock2();
        new Thread(t::m1).start();
        new Thread(t::m2).start();
    }
}
