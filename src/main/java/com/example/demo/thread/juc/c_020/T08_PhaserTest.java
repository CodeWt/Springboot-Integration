package com.example.demo.thread.juc.c_020;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * 多道栅栏，每个栅栏可以设置不同等待线程数
 */
public class T08_PhaserTest {

    static Phaser phaser = new Phase();

    static class Phase extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("第一阶段，已参加人数" + registeredParties);
                    return false;
                case 1:
                    System.out.println("第二阶段，已参加人数" + registeredParties);
                    return false;
                case 2:
                    System.out.println("第三阶段，已参加人数" + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person extends Thread {
        public Person(String name) {
            super(name);
        }

        void phase1() {
            System.out.printf("%s参与第一阶段\n", this.getName());
            sleep1(new Random().nextInt(1000));
            phaser.arriveAndAwaitAdvance();
        }

        void phase2() {
            if ("120-2".equals(this.getName())) {
                phaser.arriveAndDeregister();
            } else {
                System.out.printf("%s参与第二阶段\n", this.getName());
                sleep1(new Random().nextInt(1000));
                phaser.arriveAndAwaitAdvance();
            }

        }

        void phase3() {
            if ("120-0".equals(this.getName()) || "120-1".equals(this.getName())) {
                System.out.printf("%s参与第三阶段\n", this.getName());
                sleep1(new Random().nextInt(1000));
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            phase1();

            phase2();

            phase3();
        }
    }

    static void sleep1(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(6);
        for (int i = 0; i < 6; i++) {
            new Person("120-" + i).start();
        }
    }

}
