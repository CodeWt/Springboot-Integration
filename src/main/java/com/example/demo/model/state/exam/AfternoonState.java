package com.example.demo.model.state.exam;

public class AfternoonState extends State {
    @Override
    public void wirteProgram(Work work) {
        System.out.println("当前时间为 ：" + " 点 ，下午工作状态还不错，继续努力。。");
    }
}
