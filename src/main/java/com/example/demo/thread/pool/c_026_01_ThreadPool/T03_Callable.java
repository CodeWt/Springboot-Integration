package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class T03_Callable {
    public static void main(String[] args) {
        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "hello callable!";
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(callable);//异步执行
        System.out.println("main go on exec .");
        new Thread(()->{
            try {
                System.out.println(future.get());//阻塞等待结果
                service.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("main end.");
    }
}
