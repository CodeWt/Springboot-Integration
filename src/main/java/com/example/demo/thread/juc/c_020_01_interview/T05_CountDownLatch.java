package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class T05_CountDownLatch {
    ArrayList<Object> lists = new ArrayList<>();
    void addEle(Object o){
        lists.add(o);
    }
    int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        T05_CountDownLatch t = new T05_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch1 = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("t2 start .");
            while (true){
                if (t.size()!=5){
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 结束。");
                    latch1.countDown();
                    break;
                }
            }
        },"t2").start();
        new Thread(()->{
            System.out.println("t1 start .");
            for (int i = 0; i < 10; i++) {
                t.addEle(i);
                System.out.println("add ele " + i);
                if (t.size()==5){
                    latch.countDown();
                    try {
                        latch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
              /*  try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        },"t1").start();
    }
}
