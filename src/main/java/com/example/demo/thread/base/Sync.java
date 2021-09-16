package com.example.demo.thread.base;

import java.util.concurrent.CountDownLatch;

class Task implements Runnable{
    CountDownLatch latch ;
    int tickets;
    public Task(CountDownLatch latch,int tickets){
        this.latch = latch;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        if (tickets > 0){
            synchronized (latch){
                m1();
            }
        }
        latch.countDown();
    }

    public void m1(){
        for (int i=0;i<1000000;i++){
            --tickets;
        }
    }
}
public class Sync{
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Task task = new Task(latch,3000000);
        new Thread(task,"t1").start();
        new Thread(task,"t2").start();
        new Thread(task,"t3").start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tickets is " + task.tickets);
    }
}

