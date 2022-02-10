package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;

public class T01_WithoutVolatile {
    static ArrayList<Object> lists = new ArrayList<>();
    static void addEle(Object o){
        lists.add(o);
    }
    static int size(){
       return lists.size();
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lists.add(i);
                System.out.println("add obj " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                if (size()==5){
                    System.out.println("t2 结束！！");
                    break;
                }
            }
        }).start();


    }
}
