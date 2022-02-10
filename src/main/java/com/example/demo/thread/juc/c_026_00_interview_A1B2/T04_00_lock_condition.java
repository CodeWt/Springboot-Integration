package com.example.demo.thread.juc.c_026_00_interview_A1B2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 一个队列
 */
public class T04_00_lock_condition {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        ReentrantLock lock = new ReentrantLock();
        Condition con = lock.newCondition();
        char[] chas = "ABCDEFGHI".toCharArray();
        char[] nums = "123456789".toCharArray();
        new Thread(() -> {
            try {
                latch.await();
                lock.lock();
                for (int i = 0; i < chas.length; i++) {
                    System.out.print(chas[i]);
                    con.signal();
                    con.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                con.signal();
                lock.unlock();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                lock.lock();
                latch.countDown();
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i]);
                    con.signal();
                    con.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                con.signal();
                lock.unlock();
            }
        }, "t2").start();
    }
}
