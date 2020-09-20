package com.example.demo.model.template.two;


public class TestPaperB extends TestPaper {
    public void testQuit_N1(){
        super.testQuiz_1();
        System.out.println("答案为 ：A");
    }

    public void testQuit_N2(){
        super.testQuiz_2();
        System.out.println("答案为 ：B");
    }

    public void testQuit_N3(){
        super.testQuiz_1();
        System.out.println("答案为 ：C");
    }
}
