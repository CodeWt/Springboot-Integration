package com.example.demo.thread.juc.c_020;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 面试重点：
 * read锁可以给所有读线程共享，但不能写
 * write锁为排它锁（既不能读也不能写）
 *
 */
public class T09_ReadWriteLockTest {
    static Lock lock = new ReentrantLock();

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    static int val = 0;

    static void readVal(Lock lock){
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read val " + val);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    static void writeLock(Lock lock){
        try {
            lock.lock();
            val = 1000;
            Thread.sleep(1000);
            System.out.println("write is over!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        /*final Runnable r1 = () -> readVal(lock);
        final Runnable w1 = () -> writeLock(lock);*/

        final Runnable r1 = () -> readVal(readLock);
        final Runnable w1 = () -> writeLock(writeLock);
        for(int i=0;i<10;i++) new Thread(r1).start();
        for (int i=0;i<2;i++) new Thread(w1).start();
    }
}
