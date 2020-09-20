package com.example.demo.model.observe;

/**
 *  具体的主题类，将有关状态存入具体观察者对象；再具体主题的内部状态改变时，给所有登记过的观察者发出通知
 */
public class ConcreteSubject extends Subject{
    //具体的被观察者状态
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
