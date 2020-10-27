package com.example.demo.model.state.exam;

public class Work {
    //钟点
    public double time ;
    //工作状态
    private State currentState;
    public Work(){
        //初始化状态为上午工作状态
        currentState = new ForenoonState();
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    public void writeProgram(){
        currentState.wirteProgram(this);
    }
}
