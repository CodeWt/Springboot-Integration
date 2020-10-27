package com.example.demo.model.state.exam;

/**
 *  上午和中午工作状态类
 */
public class ForenoonState extends State {
    @Override
    public void wirteProgram(Work work) {
        if (work.time < 12){
            System.out.println("当前时间为 ：" + work.time + " 上午，精神百倍");
        }else {
            //超过12点，则转入中午工作状态
            work.setCurrentState(new NoonState());
            work.writeProgram();
        }
    }
}
