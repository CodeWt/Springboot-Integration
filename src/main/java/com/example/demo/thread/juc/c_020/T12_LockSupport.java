package com.example.demo.thread.juc.c_020;

import java.util.concurrent.locks.LockSupport;

/**
 *
 *LockSupport 使得线程暂停运行
 *
 */
public class T12_LockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    LockSupport.park();
                }
            }
        });
        t.start();
        LockSupport.unpark(t);//主线程先uppark后，线程t在park不起效了
        try {
            Thread.sleep(8*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 seconds .");
//        LockSupport.unpark(t);
    }
}
