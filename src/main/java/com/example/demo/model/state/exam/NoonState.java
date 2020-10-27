package com.example.demo.model.state.exam;

public class NoonState extends State{
    @Override
    public void wirteProgram(Work work) {
        if (work.time < 13){
            System.out.println("当前时间为 ：" + work.time + " 点，午饭，犯困，午休。");
        }
        else {
            work.setCurrentState(new AfternoonState());
            work.writeProgram();
        }
    }
}
