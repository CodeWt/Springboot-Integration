package com.example.demo.thread.pool.c_026_01_ThreadPool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T05_00_HelloThreadPool {
    static class Task implements Runnable{
        String taskName;
        public Task(String taskName){
            this.taskName = taskName;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() +" exec task "  + taskName);
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "task_" + taskName;
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(4),
                new DefaultThreadFactory(ThreadPoolExecutor.class),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.DiscardPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 8; i++) {
            executor.execute(new Task(String.valueOf(i)));
        }
//        System.out.println(executor.getQueue());
        executor.execute(new Task("001"));
//        System.out.println(executor.getQueue());
        executor.shutdown();

    }
}
