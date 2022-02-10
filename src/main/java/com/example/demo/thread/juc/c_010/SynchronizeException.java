package com.example.demo.thread.juc.c_010;

/**
 *
 * synchronize发生异常会自动释放锁
 *
 */
public class SynchronizeException{
    private static class MyCount implements Runnable{
        private int count = 0;
        @Override
        public void run() {
            add();
        }
        synchronized void add(){
            for (int i = 0; i < 10; i++) {
                count++;
//                try {
                    if (count == 5){
                        count = 5/0;//catch异常处理，锁不会释放,继续往下执行
                    }
//                }catch (ArithmeticException e){
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+ " -- " + count);
            }
        }
    }

    public static void main(String[] args) {
        MyCount m = new MyCount();
        new Thread(m::add).start();
        new Thread(m::add).start();

    }


}
