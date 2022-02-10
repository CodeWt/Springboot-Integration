package com.example.demo.thread.juc.c_020;

import java.util.concurrent.Exchanger;

/**
 *
 * 交换器，只能2线程交换
 *
 */
public class T11_Exchanger {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                String s = exchanger.exchange("T1");//阻塞等待另外一个线程
                System.out.println(Thread.currentThread().getName() + " : " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                Thread.sleep(4000);
                String s = exchanger.exchange("T2");
                System.out.println(Thread.currentThread().getName() + " : " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
