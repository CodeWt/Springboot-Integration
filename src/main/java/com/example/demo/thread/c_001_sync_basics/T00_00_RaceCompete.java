package com.example.demo.thread.c_001_sync_basics;

import java.util.concurrent.CountDownLatch;

public class T00_00_RaceCompete {
    public static long num = 0L;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
//                    synchronized (T00_00_RaceCompete.class){
                        num++;
//                    }
                }
                latch.countDown();
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        latch.await();
        System.out.println(num);
    }
}
