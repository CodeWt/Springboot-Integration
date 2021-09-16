package com.example.demo.model.strategy.msb0914.third;

import com.example.demo.model.strategy.msb0914.Cat;
import com.example.demo.model.strategy.msb0914.Dog;

import java.util.Arrays;

public class Sorter<T> {
    void swapNum(T arr[], int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void sort(T arr[],Compartor<T> compartor){
        if (arr==null||arr.length<2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int minPos = i;
            for (int j = i+1; j < N; j++) {
                minPos = compartor.compareTo(arr[minPos],arr[j]) == -1 ? minPos:j;
            }
            swapNum(arr,minPos,i);
        }
    }

    public static void main(String[] args) {
        Cat cats[] = {new Cat(5,5),new Cat(3,3),new Cat(1,1)};
        System.out.println(Arrays.toString(cats));
        new Sorter<Cat>().sort(cats,new WeightCompartor());
        System.out.println(Arrays.toString(cats));
        new Sorter<Cat>().sort(cats,new HeightCompartor());
        System.out.println(Arrays.toString(cats));
        Dog dogs[] = {new Dog(3),new Dog(2),new Dog(1)};
        System.out.println(Arrays.toString(dogs));
        new Sorter<Dog>().sort(dogs,(o1,o2)->{
            if (o1.food>o2.food) return 1;
            else if (o1.food< o2.food) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(dogs));
//        new WeightCompartor().m1();
//        new WeightCompartor().m2();
    }
}
