package com.example.demo.thread.c_008_00_atomicXXX.v2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 *
 * LongAdder 分段锁的乐观锁
 *
 */
public class T {
    private static long count1 = 0L;
    private static AtomicLong count2 = new AtomicLong();
    private static LongAdder count3 = new LongAdder();

    public static void main(String[] args) {
        //线程数
        int t_count = 1000;
        //循环次数
        int l_count = 100000;
        Object o = new Object();
        ArrayList<Thread> threads1 = new ArrayList<>();
        for (int i = 0; i < t_count; i++) threads1.add(new Thread(()->{
            synchronized (o){
                for (int j = 0; j < l_count; j++) count1++;
            }
        }));
        long start1 = System.currentTimeMillis();
        threads1.forEach(thread -> thread.start());
        threads1.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("sync : " + count1 + " - " + (System.currentTimeMillis() - start1));
        ArrayList<Thread> threads2 = new ArrayList<>();
        for (int i=0;i<t_count;i++) threads2.add(new Thread(()->{
            for(int j=0;j<l_count;j++) count2.incrementAndGet();
        }));

        long start2 = System.currentTimeMillis();
        threads2.forEach(thread -> thread.start());
        threads2.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("atomic : " + count2 + " - " + (System.currentTimeMillis() - start2));

        ArrayList<Thread> threads3 = new ArrayList<>();
        for (int i=0;i<t_count;i++) threads3.add(new Thread(()-> {
            for(int j=0;j<l_count;j++) count3.increment();
        }));
        long start3 = System.currentTimeMillis();
        threads3.forEach(thread -> thread.start());
        threads3.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("longAddr : " + count3 + " - " + (System.currentTimeMillis() - start3));
//        System.out.println(count1==count2.get());
//        System.out.println(count1==count3.longValue());
    }
}
