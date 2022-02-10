package com.example.demo.thread.juc.c_017;

/**
 * 锁定对象o，如果o的对象的属性变了，不影响锁的使用
 * 但是如果o变成另外一个对象，则锁的对象发生改变
 * 应该避免锁定的对象的引用变成另外的对象
 *锁定对象的markword的2位用于表示锁的类型
 *
 */
public class T {
    /*final*/ Object o = new Object();
    void m(){
        synchronized (o){
            while (true){
                System.out.println(Thread.currentThread().getName() + " running.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m,"t1").start();
        Thread t2 = new Thread(t::m,"t2");
        t.o=new Object();
        t2.start();

    }
}
