package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * 多种任务的管理执行
 *
 */
public class T06_01_CompletableFuture {
    static void delay(){
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static double priceOfTM(){
        delay();
        return 2.0;
    }

    static double priceOfJD(){
        delay();
        return 3.0;
    }
    static double priceOfPDD(){
        delay();
        return 1.0;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        /*long start = System.currentTimeMillis();
        CompletableFuture<Double> tm = CompletableFuture.supplyAsync(() -> priceOfTM());
        CompletableFuture<Double> jd = CompletableFuture.supplyAsync(() -> priceOfJD());
        CompletableFuture<Double> pdd = CompletableFuture.supplyAsync(() -> priceOfPDD());
        CompletableFuture.allOf(tm,jd,pdd).join();
        System.out.println("tm: " + tm.get() + " jd: " + jd.get() +" pdd: " + pdd.get());
        System.out.println(System.currentTimeMillis() - start);*/

        CompletableFuture.supplyAsync(()->priceOfPDD())
                .thenApply(String::valueOf)
                .thenApply(str-> "pdd price is : " + str)
                .thenAccept(System.out::println);
        System.in.read();
    }
}
