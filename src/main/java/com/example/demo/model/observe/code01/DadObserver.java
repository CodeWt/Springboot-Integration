package com.example.demo.model.observe.code01;

public class DadObserver implements Observer
{
    @Override
    public void actionOnEnvent(WakeUpEvent event) {
        if ("up".equals(event.eventName)){
            System.out.println(event.getSource().getClass() + " feed food。。。");
        }
    }
}
