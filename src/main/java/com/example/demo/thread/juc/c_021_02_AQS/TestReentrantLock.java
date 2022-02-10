package com.example.demo.thread.juc.c_021_02_AQS;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    private static volatile int i;

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("---");
        lock.unlock();
    }
}
