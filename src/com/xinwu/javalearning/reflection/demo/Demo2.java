package com.xinwu.javalearning.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) {
        String path = "com.xinwu.javalearning.reflection.bean.User";
        try {
            Class clazz = Class.forName(path);

            System.out.println("获取类名信息");
            System.out.println(clazz.getName());  //获取简单类名
            System.out.println(clazz.getSimpleName());  //获得全路径雷鸣

            System.out.println("获取属性信息");
            //Field[] fields = clazz.getFields();  //只能获得public的属性
            //System.out.println(fields.length);
            Field[] fields = clazz.getDeclaredFields();  //可获取所有声明的属性
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("获取方法信息");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            Method m1 = clazz.getDeclaredMethod("getId", null);
            System.out.println(m1);
            Method m2 = clazz.getDeclaredMethod("setId", Long.class);
            System.out.println(m2);

            System.out.println("获取构造器信息");
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            Constructor c1 = clazz.getDeclaredConstructor(null);
            System.out.println(c1);
            Constructor c2 = clazz.getDeclaredConstructor(Long.class, Integer.class, String.class);
            System.out.println(c2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
