package com.example.demo.model.interpreter;

/**
 *  非终结符表达式，为文法中的非终结符实现解释操作。对文法中每一条规则 R1,R2,R3 ... Rn 都需要一个具体的非终结符表达式类。
 */
public class NonTerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Contextt contextt) {
        System.out.println(this.getClass().getSimpleName() + " : 非终结符端解释器。。");
    }
}
