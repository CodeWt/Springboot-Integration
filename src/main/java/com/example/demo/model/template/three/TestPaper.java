package com.example.demo.model.template.three;

public abstract class TestPaper {
    //试题1
    public void testQuiz_1(){
        System.out.println("1.三角形的内角和为 ： \n A.180 B.90 C.360");
        System.out.println("答案为 ：" + answer_1());
    }
    //试题2
    public void testQuiz_2(){
        System.out.println("2.呼和浩特市的人口大约多少 ： \n A.100w B.200w C.300w");
        System.out.println("答案为 ：" + answer_2());
    }
    //试题3
    public void testQuiz_3(){
        System.out.println("2.天津市是直辖市吗? ： \n A.是 B.不是");
        System.out.println("答案为 ：" + answer_3());
    }
    public abstract String answer_1();
    public abstract String answer_2();
    public abstract String answer_3();
}

