package com.example.demo.model.strategy.msb0914;

import java.util.Arrays;

public class Sorter {
    static void swapNum(Comparable arr[], int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void sort(Comparable arr[]){
        if (arr==null||arr.length<2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int minPos = i;
            for (int j = i+1; j < N; j++) {
                minPos = arr[minPos].compareTo(arr[j]) == -1 ? minPos:j;
            }
            swapNum(arr,minPos,i);
        }
    }

    public static void main(String[] args) {
        Cat arr[] = {new Cat(5,5),new Cat(3,3),new Cat(1,1)};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------");
        Dog dogs[] = {new Dog(3),new Dog(2),new Dog(1)};
        System.out.println(Arrays.toString(dogs));
        sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }
}
