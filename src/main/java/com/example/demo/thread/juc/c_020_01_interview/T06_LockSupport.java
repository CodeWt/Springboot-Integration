package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.concurrent.locks.LockSupport;

public class T06_LockSupport {
    ArrayList<Object> lists = new ArrayList<>();
    void addEle(Object o){
        lists.add(o);
    }
    int size(){
        return lists.size();
    }
    static Thread t1,t2;
    public static void main(String[] args) {
        T06_LockSupport t = new T06_LockSupport();
        t2 = new Thread(() -> {
            System.out.println("t2 start.");
            while (true) {
//                if (t.size() != 5) {
                    LockSupport.park();
//                }
                System.out.println("t2 结束");
                LockSupport.unpark(t1);
                break;
            }
        }, "t2");

        t1 = new Thread(() -> {
            System.out.println("t1 start.");
            for (int i = 0; i < 10; i++) {
                t.addEle(i);
                System.out.println("add ele " + i);
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });
        t2.start();
        t1.start();
    }
}
