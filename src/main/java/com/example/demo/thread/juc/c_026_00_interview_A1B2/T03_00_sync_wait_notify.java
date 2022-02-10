package com.example.demo.thread.juc.c_026_00_interview_A1B2;

/**
 * 指定先打印字母或数字
 */
public class T03_00_sync_wait_notify {
    private enum Go {T1, T2}

    static volatile Go run = Go.T1;

    public static void main(String[] args) {
        char[] chas = "ABCDEFGHI".toCharArray();
        char[] nums = "123456789".toCharArray();
        final Object o = new Object();
        new Thread(() -> {
            while (run!=Go.T1){}
            synchronized (o) {
                run=Go.T2;
                for (int i = 0; i < chas.length; i++) {
                    System.out.print(chas[i]);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }

        }, "t1").start();
        new Thread(() -> {
            while (run!=Go.T2){}
            synchronized (o) {
                run=Go.T1;
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i]);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
