package com.example.demo.thread.juc.c_026_00_interview_A1B2;

/**
 * wait notify
 */
public class T02_00_sync_wait_notify {
    public static void main(String[] args) throws InterruptedException {
        char[] chas = "ABCDEFG".toCharArray();
        char[] nums = "1234567".toCharArray();
        final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < chas.length; i++) {
                    System.out.print(chas[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i]);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//避免程序无法终止
            }
        }, "t2").start();
    }
}
