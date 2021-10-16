package com.example.demo.model.iterator.v2;

public class LinkedList_ implements Collection_{
    private Node head=null;
    private Node tail=null;
    private int index=0;

    @Override
    public void add(Object o) {
        Node node = new Node(o);
        if (head==null){
            head=node;
            tail=node;
        }
        tail.next = node;
        tail=node;
        index++;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator_();
    }

    private class Node{
        private Object object;
        private Node next;
        public Node(Object o){
            this.object =o;
        }
    }

    private class LinkedListIterator_ implements Iterator_{
        private Node cur = head;
        @Override
        public boolean hasNext() {
            if (cur!=null)
                return true;
            return false;
        }

        @Override
        public Object next() {
            Node node = cur;
            cur = node.next;
            return node.object;
        }
    }
}
