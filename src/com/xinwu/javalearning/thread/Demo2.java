package com.xinwu.javalearning.thread;

/**
 * 创建线程的方法之二--实现runable接口
 * 这种创建线程的方式比继承Thread的方式更灵活，因为java只能单继承
 */
public class Demo2 implements Runnable {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Thread thread = new Thread(demo2); //此处是用了静态代理模式
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("count: " + i);
        }
    }
}
