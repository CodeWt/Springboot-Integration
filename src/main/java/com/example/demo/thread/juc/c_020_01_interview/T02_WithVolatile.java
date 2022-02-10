package com.example.demo.thread.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T02_WithVolatile {
    static volatile ArrayList<Object> lists = new ArrayList<>();
//    static List<Object> lists = Collections.synchronizedList(new ArrayList<>());
    static void addEle(Object obj){
        lists.add(obj);
    }
    static int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lists.add(i);
                System.out.println("add ele " + i);
                //可能Hotspot在sleep期间将值写到men，其它线程可见了
               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }).start();
        new Thread(()->{
            while (true){
                if (size()==5){
                    System.out.println("t2 结束");
                    break;
                }
            }
        }).start();
    }
}
