package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.util.*;

public class T13_ParallelStreamAPI {
    static int NUMS = 10*10000;
    static int[] nums = new int[NUMS];
    static List<Integer> integers = new ArrayList<>(NUMS);
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            integers.add(i+1);
        }
    }

    static boolean isPrime(int num){
        for (int i = 2; i <= num/2; i++) {
            if (num%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Arrays.stream(nums).forEach(value -> isPrime(value));
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        Arrays.stream(nums).parallel().forEach(T13_ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("------------");

        start = System.currentTimeMillis();
        integers.forEach(v->isPrime(v));
        end = System.currentTimeMillis();
        System.out.println(end-start);

        //forkjoinpool  parallel stream
        start = System.currentTimeMillis();
        integers.parallelStream().forEach(T13_ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
