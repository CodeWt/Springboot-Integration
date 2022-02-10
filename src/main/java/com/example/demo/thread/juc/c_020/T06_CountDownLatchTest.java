package com.example.demo.thread.juc.c_020;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class T06_CountDownLatchTest {
    static int count;
    static void test01(){
        CountDownLatch latch = new CountDownLatch(100);
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0;i<100;i++) threads.add(new Thread(()->{
            count++;
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完毕。。。");
        }));
        threads.forEach(thread -> thread.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test01,100线程执行完毕." + count);
    }
    static void test02(){
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0;i<100;i++) threads.add(new Thread(()->{
            count++;
        }));
        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("test02,100线程执行完毕." + count);
    }

    public static void main(String[] args) {
        test01();
        test02();
    }
}
