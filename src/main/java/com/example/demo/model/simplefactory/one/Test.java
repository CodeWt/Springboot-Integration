package com.example.demo.model.simplefactory.one;

import com.example.demo.exeception.MyException;

public class Test {
    public static void main(String[] args) throws MyException {
        Operator divIns = OperaterSimpleFactory.createOperater("/");
        divIns.setNumberA(2);
        divIns.setNumberB(0);
        try {
            System.out.println(divIns.getResult());
        } catch (MyException e) {
            e.printStackTrace();
            divIns.setNumberB(23);
            System.out.println(divIns.getResult());
        }
        Operator addIns = OperaterSimpleFactory.createOperater("+");
        addIns.setNumberA(2);
        addIns.setNumberB(3);
        System.out.println(addIns.getResult());

    }

}
