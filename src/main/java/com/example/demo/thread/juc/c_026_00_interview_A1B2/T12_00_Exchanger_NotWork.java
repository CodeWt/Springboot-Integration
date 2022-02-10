package com.example.demo.thread.juc.c_026_00_interview_A1B2;

import java.util.concurrent.Exchanger;

public class T12_00_Exchanger_NotWork {
    static Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String[] args) {
        char[] chas = "ABCD".toCharArray();
        char[] nums = "1234".toCharArray();
        new Thread(()->{
            for (int i = 0; i < chas.length; i++) {
                System.out.print(chas[i]);
                try {
                    exchanger.exchange("T1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        new Thread(()->{
            for (int i = 0; i < nums.length; i++) {
                try {
                    exchanger.exchange("T2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(nums[i]);
            }
        },"T2").start();
    }
}
