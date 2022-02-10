package com.example.demo.thread.join.v1;

public class JoinTest {
    private static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start.");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(myTask);
            threads[i].start();
            threads[i].join();
        }
    }
}
