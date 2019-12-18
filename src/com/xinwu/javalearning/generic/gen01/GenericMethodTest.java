package com.xinwu.javalearning.generic.gen01;

import java.io.Closeable;
import java.io.IOException;

/**
 * 泛型方法：泛型要声明在方法的返回值之前，同时在泛型方法中，只能够获取对象，而不能对对象修改
 * 因为它具体是什么类型的对象是在使用时确定的
 */
public class GenericMethodTest {
    public static <T> void test(T t) {
        System.out.println(t);
    }

    public static <T extends Closeable> void test2(T... ts) {
        for (T t : ts) {
            try {
                if (null != t) {
                    t.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
