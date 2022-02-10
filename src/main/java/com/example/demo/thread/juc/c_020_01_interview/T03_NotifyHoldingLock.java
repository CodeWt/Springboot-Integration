package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;

public class T03_NotifyHoldingLock {
    static ArrayList<Object> lists = new ArrayList<>();

    static void addEle(Object o) {
        lists.add(o);
    }

    static int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println("t2 start.");
                while (true) {
                    if (size() != 5) {
                        try {
                            o.wait();//释放锁，睡着了
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("after wait,get a notification from 't1' and get a lock ==> go!");
                        break;
                    }
                }
            }
        }, "t2").start();
        new Thread(() -> {
            synchronized (o) {
                System.out.println("t1 start.");
                for (int i = 0; i < 10; i++) {
                    if (size() == 5) {
                        o.notify();//叫醒另外wait的线程但不释放锁
                    }
                    lists.add(i);
                    System.out.println("add ele " + i);

                }
            }
        }, "t1").start();
    }
}
