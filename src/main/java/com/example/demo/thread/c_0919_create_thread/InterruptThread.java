package com.example.demo.thread.c_0919_create_thread;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            while (true) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("isInterrupted is " + Thread.currentThread().isInterrupted());
//                    break;
//
//                }
//            }
//        });
//        thread.start();
//        Thread.sleep(3);
//        thread.interrupt();
//        System.out.println("------主线程结束");
//        System.out.println("=========================");
//        Thread thread = new Thread(() -> {
//            while (true){
//                //查询当前线程标志位并重置
//                System.out.println("Thread 111");
//                if (Thread.interrupted()){
//                    System.out.println("Thread.interrupted() : " + Thread.interrupted() );
//                    break;
//                }
//            }
//        });
//        thread.start();
//        thread.interrupt();
//
//        //当前线程的中断状态即main线程
//        System.out.println("main : " + thread.interrupted());
//        System.out.println("======================");
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(5 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("查询标志位 ：" + Thread.currentThread().isInterrupted());
//            }
//
//        });
//        thread.start();
//        try {
//            Thread.sleep(3*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();

//        ============================
//        Object o = new Object();
//        Thread t1 = new Thread(() -> {
//            synchronized (o){
//                try {
//                    Thread.sleep(10*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("t1 end.");
//            }
//        });
//        t1.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread t2 = new Thread(() -> {
//            synchronized (o) {
//                System.out.println("t2 get lock success.");
//            }
//            System.out.println("t2 end.");
//        });
//        t2.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t2.interrupt();
//        ========================================

//        ReentrantLock lock = new ReentrantLock();
//        Thread t1 = new Thread(() -> {
//            lock.lock();
//            try {
//                Thread.sleep(10 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//            System.out.println("t1 end.");
//        });
//        t1.start();
//        Thread.sleep(1000);
//        Thread t2 = new Thread(() -> {
//            lock.lock();
//            try {
//
//            } finally {
//                lock.unlock();
//            }
//            System.out.println("t2 end.");
//        });
//        t2.start();
//        Thread.sleep(1000);
//        t2.interrupt();
//        ====================================
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
            System.out.println("t1 end.");
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("程序员自己空值继续抢锁  还是。。。");
            } finally {
                lock.unlock();
            }
            System.out.println("t2 end.");
        });
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();

    }
}
