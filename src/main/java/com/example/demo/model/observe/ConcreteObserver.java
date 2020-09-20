package com.example.demo.model.observe;

/**
 *  具体的观察者，实现了抽象观察者角色所要求的更新，以方便使得本身的状态与主题的状态相协调。
 */
public class ConcreteObserver extends Observer {
    //观察者名称
    private String name;
    //观察者的状态
    private String observeState;
    //具体观察者角色可以保存一个指向具体主题的对象引用
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject,String name){
        this.subject = subject;
        this.name = name;
    }
    @Override
    public void updateState() {
        this.observeState = subject.getSubjectState();
        System.out.println("观察者 " + name + " 的新状态是 " + this.observeState);
    }
}
