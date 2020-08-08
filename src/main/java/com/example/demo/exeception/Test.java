package com.example.demo.exeception;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        try {
            new MyTestExec().disMyExeception("no");
        } catch (MyException e) {
            e.printStackTrace();
        }
        while (true){
            Thread.sleep(2000);
            System.out.println("==========");
        }
    }
}
