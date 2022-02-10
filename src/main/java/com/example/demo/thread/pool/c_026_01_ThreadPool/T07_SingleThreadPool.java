package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 1.任务顺序执行
 * 2.线程的生命周期交由线程池管理
 * 3.任务队列
 *
 */
public class T07_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(()-> System.out.println(Thread.currentThread().getName() + " " + finalI));
        }
        executor.shutdown();
    }
}
