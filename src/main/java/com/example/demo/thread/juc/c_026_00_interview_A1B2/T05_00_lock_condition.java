package com.example.demo.thread.juc.c_026_00_interview_A1B2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 2个等待队列
 *
 */
public class T05_00_lock_condition
{
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition con_1 = lock.newCondition();
        Condition con_2 = lock.newCondition();
        char[] chas = "ABCDEFGHI".toCharArray();
        char[] nums = "123456789".toCharArray();
        new Thread(()->{
            try{
                lock.lock();
                for (int i = 0; i < chas.length; i++) {
                    System.out.print(chas[i]);
                    con_2.signal();
                    con_1.await();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                con_2.signal();
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i]);
                    con_1.signal();
                    con_2.await();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                con_1.signal();
                lock.unlock();
            }
        },"t2").start();
    }
}
