package com.example.demo.thread.c_001_03_ordering;

import java.io.IOException;

/**
 *
 * 1.new 分配内存（半初始化，int类型为0）
 * 2.调用构造方法进行初始化
 * 3.建立this到对象的引用关系
 * 底层2,3可能发生乱序，导致this.num=0
 *
 * 结论：不要在构造方法里面new线程，并start(可以new，但不要在构造方法里启动)
 *
 */
public class T03_ThisEscape {
    private int num=8;
    public T03_ThisEscape(){
        new Thread(()-> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        new T03_ThisEscape();
        System.in.read();
    }
}
