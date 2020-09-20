package com.example.demo.model.observe;

public class TestCli
{
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver(subject,"observerX"));
        subject.attach(new ConcreteObserver(subject,"observerY"));
        subject.attach(new ConcreteObserver(subject,"observerZ"));
        subject.setSubjectState("ABC");
        subject.inform();
    }
}
