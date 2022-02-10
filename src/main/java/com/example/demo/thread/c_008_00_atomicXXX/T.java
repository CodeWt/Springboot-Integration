package com.example.demo.thread.c_008_00_atomicXXX;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class T {
    private static AtomicInteger count = new AtomicInteger();
    static void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(T::m));
        }
        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }
}
