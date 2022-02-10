package com.example.demo.thread.juc.c_026_00_interview_A1B2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T09_00_BlockingQueue {
    static BlockingQueue queue_1 = new ArrayBlockingQueue(1);
    static BlockingQueue queue_2 = new ArrayBlockingQueue(1);

    public static void main(String[] args) {
        char[] chas = "ABCDEFGHI".toCharArray();
        char[] nums = "123456789".toCharArray();
        new Thread(()->{
            for (int i = 0; i < chas.length; i++) {
                System.out.print(chas[i]);
                try {
                    queue_2.put("ok");
                    queue_1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
        new Thread(()->{
            for (int i = 0; i < nums.length; i++) {
                try {
                    queue_2.take();
                    System.out.print(nums[i]);
                    queue_1.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}
