package com.example.demo.thread.juc.c_020;

import java.util.concurrent.Semaphore;

/**
 *
 * 限流，收费站
 *
 */


public class T10_SemaphoreTest {
    public static void main(String[] args) {
        //非公平
        Semaphore s = new Semaphore(1);
//        Semaphore s = new Semaphore(1, true);
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                try {
                    s.acquire();
                    System.out.printf("%s,start. \n" , Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.printf("%s,end. \n" , Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    s.release();
                }
            }).start();
        }
    }
}
