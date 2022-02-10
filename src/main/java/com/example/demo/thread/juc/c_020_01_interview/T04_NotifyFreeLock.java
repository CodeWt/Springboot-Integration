package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;

/**
 *
 *
 * wait/notify重点，背
 *
 *
 */
public class T04_NotifyFreeLock {
    ArrayList<Object> lists = new ArrayList<>();
    void addEle(Object o){
        lists.add(o);
    }
    int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        T03_NotifyHoldingLock t = new T03_NotifyHoldingLock();
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                System.out.println("t2 start.");
                while (true){
                    if (t.size()!=5){
                        try {
                            //释放锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (t.size()==5){
                            System.out.println("t2 结束。");
                            //通知叫醒t1
                            lock.notify();
                            break;
                        }
                    }
                }
            }
        },"t2").start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("t1 start.");
                for (int i = 0; i < 10; i++) {
                    if (t.size()==5){
                        lock.notify();//通知t2
                        try {
                            lock.wait();//当前线程释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    t.addEle(i);
                    System.out.println("add ele " + i);
                }
            }
        }).start();
    }
}
