package com.example.demo.thread.juc.c_001;

import java.util.concurrent.CountDownLatch;

public class SynchronizeLock {
    private static int count = 10000;
    private static Object o = new Object();
    private static class MyThread extends Thread{
        private final CountDownLatch latch;
        public MyThread(CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void run() {
            synchronized (o){
                count --;
                latch.countDown();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new MyThread(latch).start();
        }
        latch.await();
        System.out.println(count);
    }

}
