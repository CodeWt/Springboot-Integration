package com.example.demo.model.iterator.v1;


public class LinkedList_ implements Collection_ {

    //头指针
    private Node head=null;
    //尾指针
    private Node tail=null;
    //容器大小
    private int size;

    public void add(Object o){
        Node node = new Node(o);
        if (head==null){
            head=node;
            tail=node;
        }
        tail.next = node;
        tail = node;
        size++;

    }

    public void dis(){
        Node node = this.head;
        for (int i = 0; i < size; i++) {
            System.out.println(node.object);
            node = node.next;
        }
    }

    public int size(){
        System.out.println(head.object);
        return this.size;
    }

    private class Node{
        private Object object;
        private Node next;

        public Node(Object object) {
            this.object = object;
        }
    }
}

