package com.example.demo.thread.juc.c_020;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 公平（如果有检查队列有其它线程，会排队进入队列）、非公平锁（不会进入队列，直接抢锁）
 * synchronized非公平锁
 *
 */
public class T05_ReentrantLock5 {
    private final Lock lock = new ReentrantLock(true);
    void m(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获得锁.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock5 t = new T05_ReentrantLock5();
        new Thread(t::m).start();
        new Thread(t::m).start();
    }
}
