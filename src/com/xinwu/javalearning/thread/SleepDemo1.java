package com.xinwu.javalearning.thread;

//Thread.sleep方法，不释放锁睡眠。
public class SleepDemo1 {
    public static void main(String[] args) {
        int i = 10;
        while (true) {
            System.out.println("main thread: " + i--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i <= 0) {
                break;
            }
        }
    }
}
