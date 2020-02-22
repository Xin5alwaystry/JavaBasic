package com.xinwu.javalearning.thread;

public class SynchronizedDemo {
    public static void main(String[] args) {
        Web12305 web = new Web12305();
        Thread t1 = new Thread(web, "lebron");
        Thread t2 = new Thread(web, "wade");
        Thread t3 = new Thread(web, "paul");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Web12305 implements Runnable {
    private int total = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test3();
        }
    }

    private void stop() {
        this.flag = false;
    }

    //test1 线程不安全
    private void test1() {
        if (total <= 0) {
            stop();
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"抢到了第" + total-- + "张票");
    }

    //test2 对方法加锁  线程安全
    private synchronized void test2() {
        if (total <= 0) {
            stop();
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"抢到了第" + total-- + "张票");
    }

    //test3 同步方法块 线程安全
    public void test3() {
        synchronized (this) {
            if (total <= 0) {
                stop();
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"抢到了第" + total-- + "张票");
        }
    }
}