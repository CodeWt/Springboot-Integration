package com.example.demo.thread;

public class Test {
        public static void main(String[] args) {
            RWLockTool tool = new RWLockTool();
            for (int i = 0;i<3;i++){
                new Thread(new ReadTask(tool)).start();
                new Thread(new WriteTask(tool)).start();
            }
        }

}
