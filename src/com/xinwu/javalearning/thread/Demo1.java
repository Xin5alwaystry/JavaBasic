package com.xinwu.javalearning.thread;

/**
 * 创建线程方式之一：继承Thread类，重写run方法
 */
public class Demo1 extends Thread {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("count: " + i);
        }
    }
}

