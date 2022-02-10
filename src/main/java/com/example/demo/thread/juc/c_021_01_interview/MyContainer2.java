package com.example.demo.thread.juc.c_021_01_interview;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {
    private final LinkedList<T> lists = new LinkedList<>();
    private final int MAX = 10;
    private int count = 0;

    final Lock lock = new ReentrantLock();
    //consumer等待队列
    final Condition consumer = lock.newCondition();
    //produer等待队列
    final Condition producer = lock.newCondition();

    void putObj(T ele) {
        try {
            lock.lock();
            while (count == MAX) {
                //阻塞放入producer等待队列等待被叫醒
                producer.await();
            }
            lists.add(ele);
            count++;
            consumer.signalAll();//叫醒所有consumer等待队列中的消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    T getObj(){
        T t =null;
        try {
            lock.lock();
            while (count==0){
                //阻塞放入consumer等待队列等待被叫醒
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();//叫醒所有producer等待队列中的生产者
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> container2 = new MyContainer2<>();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) container2.putObj(Thread.currentThread().getName() + " produce obj-" + j);
            },"producer" + i).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for(int j=0;j<5;j++) System.out.println(Thread.currentThread().getName() + " consume ==> " + container2.getObj());
            },"consumer" + i).start();
        }
    }

}
