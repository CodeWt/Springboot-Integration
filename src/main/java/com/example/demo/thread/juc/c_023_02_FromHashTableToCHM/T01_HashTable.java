package com.example.demo.thread.juc.c_023_02_FromHashTableToCHM;

import java.util.Hashtable;
import java.util.UUID;

public class T01_HashTable {
    static Hashtable<UUID,UUID> m = new Hashtable<>();
    static int threadCount = Constants.THREAD_COUNT;
    static int keysCount=Constants.KV_P_COUNT;
    static UUID[] keys = new UUID[keysCount];
    static UUID[] vals = new UUID[keysCount];
    static {
        for (int i = 0; i < keysCount; i++) {
            keys[i] = UUID.randomUUID();
            vals[i]= UUID.randomUUID();
        }
    }
    static class MyThread extends Thread{
        private int startIndex;
        private int endIndex;
        public MyThread(int startIndex,int endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                m.put(keys[i],vals[i]);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];
        int loopCount = keysCount/threadCount;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i * loopCount,(i + 1 ) * loopCount);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(m.size());
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000 * 10000; j++) {
                    m.get(keys[10]);
                }
            });
        }
        long readStart = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(System.currentTimeMillis() - readStart);
    }
}
