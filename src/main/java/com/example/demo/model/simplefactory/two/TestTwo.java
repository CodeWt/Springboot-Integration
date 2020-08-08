package com.example.demo.model.simplefactory.two;

import java.util.Scanner;

public class TestTwo {
    public static double total;
    public static void onClick(){
        //输入活动类型
        CashSuper cashSuper = CashFactory.createCashAccept(new Scanner(System.in).nextLine());
        //输入单价 * 输入数量
        double singlePrice = new Scanner(System.in).nextDouble();
        int count = new Scanner(System.in).nextInt();
        double totalPrice = cashSuper.acceptCash( singlePrice * count);
        System.out.println("商品名 : Good-" + Math.random() + " 数量: " + count + " 合计: " + totalPrice);
        total += totalPrice;
    }
    public static void main(String[] args) {
        onClick();
        onClick();
        onClick();
        System.out.println("消费总计 : " + total);
    }
}
