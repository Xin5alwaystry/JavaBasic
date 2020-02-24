package com.xinwu.javalearning.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        System.out.println("start: " + System.currentTimeMillis());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("current time: " + System.currentTimeMillis());
            }
        }, 1000, 200);
    }
}
