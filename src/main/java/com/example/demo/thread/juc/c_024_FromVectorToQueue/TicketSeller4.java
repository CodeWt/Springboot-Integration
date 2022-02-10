package com.example.demo.thread.juc.c_024_FromVectorToQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue();
    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号 " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String poll = tickets.poll();
                    if (poll!=null) System.out.println(Thread.currentThread().getName() + " sell " + poll);
                    else break;
                }
            }).start();
        }
    }
}
