package com.xinwu.javalearning.thread;

/**
 * Thread的join方法，合并线程
 */
public class JoinDemo extends Thread {
    public static void main(String[] args) {
        JoinDemo demo = new JoinDemo();
        demo.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread: " + i);
            if (i == 50) {
                try {
                    //此时把主线程阻塞，待demo线程完成。
                    demo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join thread: " + i);
        }
    }
}
