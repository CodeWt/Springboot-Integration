package com.example.demo.thread.juc.c002;

import java.util.concurrent.CountDownLatch;

public class MyThread {
    private static class MyTask implements Runnable{
        private final CountDownLatch latch;

        public MyTask(CountDownLatch latch){
            this.latch = latch;
        }
        private int count = 10000;
        private Object o = new Object();
        @Override
        public void run() {
            synchronized (o){
//            synchronized (this){
                count --;
            }
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10000);
        MyTask myTask = new MyTask(latch);
        for (int i = 0; i < 10000; i++) {
            new Thread(myTask).start();
        }
        latch.await();
        System.out.println(myTask.count);
    }

}
