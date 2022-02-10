package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T09_FixedThreadPool {
    static List<Integer> getPrime(int start,int end) {
        if (start < 1) start=1;
        if (end - start < 0) return null;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            if (i == 1) {
                list.add(1);
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0) break;
                if (j == i - 1) list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> prime = getPrime(0, 20 * 10000);
        System.out.println(System.currentTimeMillis()-start + " " + prime.size());

        long l = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<List<Integer>> f1 = service.submit(() -> getPrime(0, 10 * 10000));
        Future<List<Integer>> f2 = service.submit(() -> getPrime(10 * 10000+1, 20 * 10000));
        List<Integer> p1 = f1.get();
        List<Integer> p2 = f2.get();
        System.out.println(System.currentTimeMillis()-l + " " + (p1.size() + p2.size()));
        service.shutdown();

       /* List<Integer> prime = getPrime(1, 30);
        System.out.println(Arrays.toString(prime.toArray()));*/
    }
}
