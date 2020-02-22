package com.xinwu.javalearning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建线程的方式之==继承Callable接口，有返回值。需要借助线程池
 */
public class Demo3 implements Callable<Long> {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Demo3 demo3 = new Demo3();
        ArrayList<Demo3> list = new ArrayList<>();
        list.add(demo3);
        try {
            List<Future<Long>> futureList = es.invokeAll(list);
            for (Future future : futureList) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long call() throws Exception {
        return System.currentTimeMillis();
    }
}
