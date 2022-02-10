package com.example.demo.thread.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 *  Guava RateLimiter
 *
 */
public class T07_CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10,()-> System.out.println(Thread.currentThread().getName() + "满员发车 ==>  go"));
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " 已在路上.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
