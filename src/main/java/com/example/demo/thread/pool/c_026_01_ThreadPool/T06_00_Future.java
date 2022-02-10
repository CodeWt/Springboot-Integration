package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class T06_00_Future {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            Thread.sleep(5000);
            return 1;
        });

        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
