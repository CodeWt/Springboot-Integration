package com.example.demo.model.iterator;

import com.example.demo.model.iterator.v1.Collection_;
import com.example.demo.model.iterator.v1.LinkedList_;

public class Main {
    public static void main(String[] args) {
        Collection_ list_ = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list_.add(new String("Array ele-" + i));
        }
        list_.dis();
        list_.dis();
    }
}


