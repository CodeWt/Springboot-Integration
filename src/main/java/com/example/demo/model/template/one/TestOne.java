package com.example.demo.model.template.one;


/**
 *  测试客户端
 */
public class TestOne {
    public static void main(String[] args) {
        System.out.println("---------学生A的试卷 ：");
        TestPaperA testPaperA = new TestPaperA();
        testPaperA.testQuiz_1();
        testPaperA.testQuiz_2();
        testPaperA.testQuiz_3();
        System.out.println("---------学生A的试卷 ：");
        TestPaperB testPaperB = new TestPaperB();
        testPaperB.testQuiz_1();
        testPaperB.testQuiz_2();
        testPaperB.testQuiz_3();

    }
}
