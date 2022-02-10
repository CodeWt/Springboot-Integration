package com.example.demo.thread.c_001_03_ordering;

import java.util.concurrent.CountDownLatch;

/**
 *
 * t1,t2都发生乱序，打印(0,0)
 *
 */
public class T01_DisOrder {
    private static int x,y;
    private static int a,b;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            x=0;
            y=0;
            a=0;
            b=0;
            CountDownLatch countDownLatch = new CountDownLatch(2);
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
                countDownLatch.countDown();
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
                countDownLatch.countDown();
            });

            t1.start();
            t2.start();
            countDownLatch.await();
            String res = "第" + i + "次 (" + x + "," + y +")";
            if (x==0&&y==0){
                System.err.println(res);
                break;
            }
        }
    }
}
