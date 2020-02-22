package com.xinwu.javalearning.thread;

/**
 * 测试Thread静态方法yield，暂停自己的线程
 */
public class YieldDemo extends Thread {
    public static void main(String[] args) {
        YieldDemo demo = new YieldDemo();
        demo.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread: " + i);
            if (i % 20 == 0) {
                //在哪个线程中执行，阻塞哪个线程。
                Thread.yield();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("yieldDemo thread: " + i);
        }
    }
}
