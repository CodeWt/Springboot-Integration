package com.example.demo.thread.juc.c_008;

/**
 *
 * 对写业务加锁
 * 对读业务不加锁
 *
 * dirty read(脏读)
 */
public class Account {
    private String name;
    private double balance;

    public synchronized void setBalance(String name,double balance) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(){
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(()-> account.setBalance("zt",100)).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
    }
}
