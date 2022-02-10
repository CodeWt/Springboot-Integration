package com.example.demo.thread.juc.c_025;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 *
 * map==> 1.hashmap无序
 *        2.treemap有序map（红黑树）
 *
 *
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        //高并发下的无序map
        ConcurrentHashMap<String, String> m = new ConcurrentHashMap<>();
        //高并发下的有序map
        ConcurrentSkipListMap<Object, Object> skipListMap = new ConcurrentSkipListMap<>();
    }
}
