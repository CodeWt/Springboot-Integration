package com.example.demo.model.iterator.v3;


public class ArrayList_ <E> implements Collection_<E>{
    private Object[] objects=new Object[10];
    private int index=0;
    @Override
    public void add(E ele) {
        if (index==objects.length){
            Object[] newObjects = new Object[this.objects.length * 2];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects=newObjects;
        }
        objects[index++]=ele;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator_<E>{

        private int pos = 0;

        @Override
        public boolean hasNext() {
            if (pos==index) return false;
            return true;
        }

        @Override
        public E next() {
            return (E) objects[pos++];
        }
    }

}
