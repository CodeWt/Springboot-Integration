package com.example.demo.model.simpleFactoryStrategy;

import java.util.Scanner;

public class ClientTest {
    static double total;
    public static void onClick(){
        CashContext cashContext = new CashContext(new Scanner(System.in).next());
        total += cashContext.getResult(new Scanner(System.in).nextDouble() * new Scanner(System.in).nextInt());
    }

    public static void main(String[] args) {
        for (int i =0;i< 3;i++){
            onClick();
        }
        System.out.println("sum : " + total);
    }
}
