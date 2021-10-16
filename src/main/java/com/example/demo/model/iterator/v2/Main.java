package com.example.demo.model.iterator.v2;

public class Main {
    public static void main(String[] args) {
        Collection_ list_=new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list_.add(new String("iter " + i));
        }
        System.out.println(list_.size());
        Iterator_ iterator = list_.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------Array-----------");
        Collection_ li_ =new ArrayList_();
        for (int i = 0; i < 15; i++) {
            li_.add(new String("arr-iter " + i));
        }
        System.out.println(li_.size());
        Iterator_ iterator1 = li_.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
