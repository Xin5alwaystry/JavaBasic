package com.xinwu.javalearning.thread.producer;

public class Player implements Runnable {
    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0 ; i< 20; i++) {
            if (0 == i%2) {
                m.play("天王盖地虎");
            } else {
                m.play("宝塔镇河妖");
            }
        }
    }
}
