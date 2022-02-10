package com.example.demo.thread.juc.c_026_00_interview_A1B2;

public class T06_00_cas {
    enum ReadyGo{T1,T2}
    static volatile ReadyGo r = ReadyGo.T1;
    public static void main(String[] args) {
        char chars[] = "ABCDEFGHI".toCharArray();
        char nums[] =  "123456789".toCharArray();
        new Thread(()->{
            for (int i = 0; i < chars.length; i++) {
                while (r!=ReadyGo.T1){}
                System.out.print(chars[i]);
                r=ReadyGo.T2;
            }
        },"T1").start();
        for (int i = 0; i < nums.length; i++) {
            while (r!=ReadyGo.T2){}
            System.out.print(nums[i]);
            r=ReadyGo.T1;
        }
    }
}
