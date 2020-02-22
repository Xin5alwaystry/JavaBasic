package com.xinwu.javalearning.thread;

/**
 * 死锁案例。对同一个资源更多的加🔒，要注意死锁现象。
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object goods = new Object();
        Object moneys = new Object();
        GiveMoney giveMoney = new GiveMoney(goods, moneys);
        GiveGoods giveGoods = new GiveGoods(goods, moneys);
        Thread money = new Thread(giveMoney);
        Thread good = new Thread(giveGoods);
        money.start();
        good.start();
    }
}

class GiveMoney implements Runnable {
    Object goods;
    Object money;

    public GiveMoney(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }


    @Override
    public void run() {
        while(true) {
            synchronized (goods) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (money) {
                }
            }
            System.out.println("先给钱");
        }
    }
}

class GiveGoods implements Runnable {
    Object goods;
    Object money;

    public GiveGoods(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }


    @Override
    public void run() {
        while(true) {
            synchronized (money) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (goods) {
                }
            }
            System.out.println("先给或");
        }
    }
}