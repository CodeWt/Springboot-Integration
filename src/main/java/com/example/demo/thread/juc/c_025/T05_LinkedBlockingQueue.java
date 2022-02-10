package com.example.demo.thread.juc.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class T05_LinkedBlockingQueue {
    static BlockingQueue<String> queue = new LinkedBlockingDeque<>();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    try {
                        queue.put(Thread.currentThread().getName()+" put " + new Random().nextInt(10000));
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"p" + i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true){
                    String s = null;
                    try {
                        s = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " take --> " + s);
                }
            },"c"+i).start();

        }
    }
}
