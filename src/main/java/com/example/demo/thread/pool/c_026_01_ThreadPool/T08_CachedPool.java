package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T08_CachedPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            service.submit(()-> {
                try {
                    Thread.sleep(new Random().nextInt(160));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" " + finalI);
            });
        }
        System.out.println(service);
        Thread.sleep(80);
        System.out.println(service);
        service.shutdown();
    }
}
