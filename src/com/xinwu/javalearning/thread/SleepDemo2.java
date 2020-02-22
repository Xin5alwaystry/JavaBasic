package com.xinwu.javalearning.thread;

public class SleepDemo2 {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread thread1 = new Thread(web12306, "lebron");
        Thread thread2 = new Thread(web12306, "wade");
        Thread thread3 = new Thread(web12306, "paul");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Web12306 implements Runnable {
    //此时会出现并发问题
    private int total = 500000;

    @Override
    public void run() {
        while (true) {
            if (total < 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + total-- + "票");
        }
    }
}