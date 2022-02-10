package com.example.demo.thread.c_001_00_cachedLine;

import sun.misc.Contended;

import java.util.concurrent.CountDownLatch;

public class CachedLine {
    private static long COUNT=10_0000_0000L;
    private static class T{
        private long x1,x2,x3,x4,x5,x6,x7;

//        只有1.8起作用且加jvm参数，保证同其它数据不会缓存到一行
//        @Contended
        public /*volatile*/ long x = 0L;
        private long y1,y2,y3,y4,y5,y6,y7;
    }
    public static T arr[] = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            count.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            count.countDown();
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        count.await();
        System.out.println((System.nanoTime() - start)/100_0000);
    }
}
