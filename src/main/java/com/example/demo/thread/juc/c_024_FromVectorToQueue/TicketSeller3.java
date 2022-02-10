package com.example.demo.thread.juc.c_024_FromVectorToQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TicketSeller3 {
    static List<String> tickets = new LinkedList<>();
    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号 " +i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                synchronized (tickets){
                    while (tickets.size()>0){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " sell " + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
