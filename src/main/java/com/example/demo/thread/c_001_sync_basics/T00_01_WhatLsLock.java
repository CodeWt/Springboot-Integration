package com.example.demo.thread.c_001_sync_basics;

/**
 *
 * 上锁本质：把并发执行改成序列化执行
 *
 */
public class T00_01_WhatLsLock {
    private static Object o = new Object();

    public static void main(String[] args) {
        Runnable r = () ->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName() + " start...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end...");
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(r).start();
        }
    }
}
