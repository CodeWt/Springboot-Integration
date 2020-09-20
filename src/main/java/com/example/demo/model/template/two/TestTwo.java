package com.example.demo.model.template.two;


public class TestTwo {
    public static void main(String[] args) {
        System.out.println("=========学生A的试卷==========");
        TestPaperA paperA = new TestPaperA();
        paperA.testQuit_N1();
        paperA.testQuit_N2();
        paperA.testQuit_N3();
        System.out.println("=========学生B的试卷==========");
        TestPaperB paperB = new TestPaperB();
        paperB.testQuit_N1();
        paperB.testQuit_N2();
        paperB.testQuit_N3();

    }
}
