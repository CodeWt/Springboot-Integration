package com.example.demo.thread.c_001_03_ordering;

/**
 *
 * 2大问题：
 * flag的可见性，
 * num、flag乱序问题
 *
 */
public class T02_NoVisibility extends Thread{
    private static boolean flag=false;
    private static int num;
    @Override
    public void run() {
        while (!flag){
            Thread.yield();
        }
        System.out.println(num);
    }

    public static void main(String[] args) throws InterruptedException {
        T02_NoVisibility t1 = new T02_NoVisibility();
        t1.start();
        num = 25;
        flag = true;
        t1.join();
    }
}
