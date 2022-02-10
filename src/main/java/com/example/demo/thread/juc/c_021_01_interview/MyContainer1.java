package com.example.demo.thread.juc.c_021_01_interview;

import java.util.LinkedList;

/**
 *
 *面试题：写一个固定容器，拥有put，get及getCount方法，
 * 能够支持2个生产者线程和10个消费者线程的阻塞调用
 *
 * 使用wait 和notify/notifyAll来实现
 *
 *
 */
public class MyContainer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count=0;
    synchronized void put(T obj){
        //why is not if ?
        while (count==MAX){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(obj);
        count++;
        this.notifyAll();//通知消费者进行消费（通知对象包括生产者）
    }
    synchronized T get(){
        //why is not if?
        while (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = lists.removeFirst();
        count--;
        this.notifyAll();//通知生产者生产（通知对象包括消费者）
        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> container1 = new MyContainer1<>();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) container1.put(Thread.currentThread().getName() + " produce obj-" + j);
            },"producer" + i).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for(int j=0;j<5;j++) System.out.println(Thread.currentThread().getName() + " consume ==> " + container1.get());
            },"consumer" + i).start();
        }
    }
}
