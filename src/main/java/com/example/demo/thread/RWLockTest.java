package com.example.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class RWLockTool {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    private int num;
    public void readSharedNum(){
        readLock.lock();
        System.out.println(Thread.currentThread().getId() + "-- start read ...");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId() + " read num is : " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public void writeSharedNum(){
        writeLock.lock();
        System.out.println(Thread.currentThread().getId() + "++ start write ...");
        try {
            Thread.sleep(1000);
            num = (int) (Math.random() * 10);
            System.out.println(Thread.currentThread().getId() + " write num is : " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }
}
class ReadTask extends Thread{
    private RWLockTool rwLockTool;
    public ReadTask(RWLockTool rwLockTool){
        this.rwLockTool = rwLockTool;
    }
    @Override
    public void run() {
        rwLockTool.readSharedNum();
    }
}

class WriteTask extends Thread{
    private RWLockTool rwLockTool;
    public WriteTask(RWLockTool rwLockTool){
        this.rwLockTool = rwLockTool;
    }

    @Override
    public void run() {
        rwLockTool.writeSharedNum();
    }
}
class RWLockTest{
    public static void main(String[] args) {
        RWLockTool tool = new RWLockTool();
        for (int i = 0;i < 5;i++){
            new ReadTask(tool).start();
            new WriteTask(tool).start();
        }
    }
}