package com.example.demo.model.template.three;


public class TestThree {
    public static void main(String[] args) {
        System.out.println("*********学生A的试卷 : ");
        TestPaper paper = new TestPaperA();
        paper.testQuiz_1();
        paper.testQuiz_2();
        paper.testQuiz_3();
        System.out.println("*********学生B的试卷 : ");
        TestPaper paper1 = new TestPaperB();
        paper1.testQuiz_1();
        paper1.testQuiz_2();
        paper1.testQuiz_3();

    }
}
