package com.example.demo.thread.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T03_ReentrantLock3 {
    Lock lock = new ReentrantLock();
    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void m2(){
        boolean getLock = false;
        try {
            getLock = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2 - " + getLock);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            if (getLock) lock.unlock();
        }
    }

    public static void main(String[] args) {
        T03_ReentrantLock3 t = new T03_ReentrantLock3();
        new Thread(t::m1).start();
        new Thread(t::m2).start();
    }
}
