package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * 扩展思路。。。
 *
 *
 */
public class T08_Semaphore {
    ArrayList<Object> lists = new ArrayList<>();
    void addEle(Object o){
        lists.add(o);
    }
    int size(){
        return lists.size();
    }
    public static void main(String[] args) throws InterruptedException {
        T08_Semaphore t = new T08_Semaphore();
        Semaphore s = new Semaphore(1);
        Thread t2 = new Thread(() -> {
            System.out.println("t2 start.");
            while (true) {
                if (t.size() == 5) {
                    System.out.println("t2 结束。");
                    break;
                }
            }
        }, "t2");

        new Thread(()->{
            System.out.println("t1 start.");
            try {
                s.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                t.addEle(i);
                System.out.println("add ele " + i);
            }
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 5; i <10 ; i++) {
                t.addEle(i);
                System.out.println("add ele " + i);
            }
        },"t1").start();
    }
}
