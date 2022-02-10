package com.example.demo;

public class Test {

    static void printPerBit(int num){
        for (int i=31;i>=0;i--){
            System.out.print((num & (1<<i))==0 ? "0":"1");
        }
        System.out.println();
    }

    @org.junit.Test
    public void test01(){
        int a = 3 << 4;
        System.out.println(a);
        printPerBit(15);
    }
}
