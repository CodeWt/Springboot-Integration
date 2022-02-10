package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.concurrent.*;

public class T14_MyRejectedHandler {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                60, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new MyRejectedHandler()
        );
        for (int i = 0; i < 7; i++) {
            executor.execute(()-> {
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    static class MyRejectedHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(r);
            System.out.println(executor);
            //log.info("拒绝任务r的执行")
            //save redis,mysql,kafka
//            executor.getQueue().size()<4
        }
    }
}
