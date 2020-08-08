package com.example.demo.model.strategy;

import com.example.demo.model.simplefactory.two.CashNormal;
import com.example.demo.model.simplefactory.two.CashRebate;
import com.example.demo.model.simplefactory.two.CashReturn;

import java.util.Scanner;

public class ClientTest {
    static double total;
    public static void onClick(){
        CashContext cashContext = null;
        switch (new Scanner(System.in).next()){
            case "normal":
                cashContext = new CashContext(new CashNormal());
                break;
            case "rebate:0.8":
                cashContext = new CashContext(new CashRebate(0.8));
                break;
            case "return:300:100":
                cashContext = new CashContext(new CashReturn(300,100));
                break;
        }
        double totalPrice = cashContext.getResult(new Scanner(System.in).nextDouble() * new Scanner(System.in).nextInt());
        total += totalPrice;
    }
    public static void main(String[] args) {
        onClick();
        onClick();
        onClick();
        System.out.println("总计 : " + total);
    }
}
