package com.example.demo.exeception;

public class MyTestExec {
    public void disMyExeception(String string) throws MyException {
        System.out.println("-------------");
        if ("no".equals(string)){
            throw new MyException("dot not say word no !");
        }
    }
}
