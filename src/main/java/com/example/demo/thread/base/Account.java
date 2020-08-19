package com.example.demo.thread.base;

public class Account {
    private String name;
    private double balance;

    public double getBalance() {
        System.out.println(this.balance);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.balance);
        return balance;
    }

    public synchronized void setBalance(String name,double balance) {
        this.name = name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> account.setBalance("wt",100),"t1").start();
        new Thread(account::getBalance,"t2").start();
    }
}
