package com.example.demo.thread.juc.c_020;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T04_ReentrantLock4 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            System.out.println("m1 start.");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        try {
//            lock.lock();
            lock.lockInterruptibly();
            System.out.println("m2.");
        } catch (InterruptedException e) {
            System.out.println("interrupted.");
        }finally {
            lock.unlock();
        }
        System.out.println("m2 end.");
    }

    public static void main(String[] args) throws InterruptedException {
        T04_ReentrantLock4 t = new T04_ReentrantLock4();
        new Thread(t::m1).start();
        Thread.sleep(1000);
        Thread t1 = new Thread(t::m2);
        t1.start();
        t1.interrupt();
    }
}
