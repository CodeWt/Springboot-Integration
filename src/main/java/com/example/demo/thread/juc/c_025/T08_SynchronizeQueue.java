package com.example.demo.thread.juc.c_025;

import java.util.concurrent.SynchronousQueue;

/**
 *
 * 同步queue（线程一对一交互）
 *
 */
public class T08_SynchronizeQueue {
    //容量为0的queue
    static SynchronousQueue<String> q = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            String s = null;
            try {
                s = q.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }).start();
        q.put("jfsdj");//阻塞等待其它线程来消费

        System.out.println(q.size());
    }
}
