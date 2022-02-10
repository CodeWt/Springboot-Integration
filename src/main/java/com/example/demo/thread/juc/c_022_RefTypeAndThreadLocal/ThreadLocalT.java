package com.example.demo.thread.juc.c_022_RefTypeAndThreadLocal;

/**
 *
 * 不同的线程维护一个私有的map
 *
 */
public class ThreadLocalT {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Person> local = new ThreadLocal<>();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" +local.get());
        },"t1").start();
        Thread.sleep(1000);
        new Thread(()->{
            local.set(new Person());
            System.out.println(Thread.currentThread().getName() + "--" +local.get().name);
        },"t2").start();
    }
}
