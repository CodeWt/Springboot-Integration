package com.example.demo.thread.juc.c_025;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> queue=new ArrayBlockingQueue<>(10);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            queue.put(i + "");
        }
//        queue.put("xx");
//        queue.add("oo");
//        queue.offer("ox");
//        queue.offer("xo",1, TimeUnit.SECONDS);
    }
}
