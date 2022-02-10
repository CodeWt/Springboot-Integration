package com.example.demo.thread.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 *
 * 等待多个线程消费
 *
 *
 */
public class T09_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> q = new LinkedTransferQueue<>();
        new Thread(()->{
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        q.transfer("jfds");//阻塞确认完其它线程取走后，继续往下执行

        q.put("xxewe");
        new Thread(()->{
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
