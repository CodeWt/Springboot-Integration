package com.example.demo.model.iterator.v3;

public class Main {
    public static void main(String[] args) {
        ArrayList_<String> list_ = new ArrayList_<>();
        for (int i = 0; i < 15; i++) {
            list_.add("iter " + i);
        }
        System.out.println(list_.size());
        System.out.println("-----------");
        Iterator_<String> iterator = list_.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
