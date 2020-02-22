package com.xinwu.javalearning.thread.producer;

/**
 * wait, notify, notifyAll需要搭配synchronized使用。
 * wait 和 sleep 区别在于，wait释放锁，sleep不释放锁。
 * 这里用flag标志的方式实现生产者消费者模式，也称作"信号灯"法。
 */
public class Movie {
    private String name;
    /**
     * flag: F 生产者等待，消费者消费
     *       T 生产者生产，消费者等待
     */
    private boolean flag = true;

    //生产者，播放电影
    public synchronized void play(String name) {
        if (!flag) {
            try {
                //生产者等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产者生产ing
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生产者生产完毕
        this.name = name;
        System.out.println("播放：" + name);
        //通知消费者消费
        this.notify();
        //生产者停止生产
        this.flag = false;
    }

    //消费者观看电影
    public synchronized void watch() {
        if (flag) {
            try {
                //消费者等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            //消费者消费
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("观看：" + name);
        //消费者通知生产者生产
        this.notify();
        //消费者停止消费
        this.flag = true;
    }
}
