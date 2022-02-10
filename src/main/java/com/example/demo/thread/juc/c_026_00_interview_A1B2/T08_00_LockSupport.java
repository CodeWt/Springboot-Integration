package com.example.demo.thread.juc.c_026_00_interview_A1B2;

import java.util.concurrent.locks.LockSupport;

public class T08_00_LockSupport {
    static String[] chars = new String[]{
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N",
            "O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };
    static Thread t1,t2;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");
        t2 = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                LockSupport.park();
                System.out.print(i);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
