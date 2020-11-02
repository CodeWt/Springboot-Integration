package com.example.demo.model.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 *   构建表示该文法定义的语言中一个特定的句子的抽象语法树。调用解释操作。
 */
public class TestCli {
    public static void main(String[] args) {
        Contextt contextt = new Contextt();
        List<AbstractExpression> li = new ArrayList<>();
        li.add(new TerminalExpression());
        li.add(new NonTerminalExpression());
        li.add(new TerminalExpression());
        li.add(new TerminalExpression());
        for (AbstractExpression expression : li){
            expression.interpret(contextt);
        }
    }
}
