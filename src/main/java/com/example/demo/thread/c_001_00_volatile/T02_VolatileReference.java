package com.example.demo.thread.c_001_00_volatile;

/**
 *
 * volatile修饰引用类型(包括数组)，只保证引用本身的可见性，而对引用对象内部的值变化不保证可见性
 *
 */
public class T02_VolatileReference {
    static class ReferenceO{
        private /*volatile*/ boolean flag=true;
        void running(){
            System.out.println("start.");
            while (flag){

            }
            System.out.println("end ...");
        }
    }
    private static volatile ReferenceO referenceO= new ReferenceO();

    public static void main(String[] args) throws InterruptedException {
        new Thread(referenceO::running,"t1").start();
        Thread.sleep(1000);
        referenceO.flag=false;
    }
}
