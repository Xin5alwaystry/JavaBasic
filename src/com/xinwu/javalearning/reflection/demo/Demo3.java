package com.xinwu.javalearning.reflection.demo;

import com.xinwu.javalearning.reflection.bean.User;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射创建对象，调用方法，修改属性的值
 */
public class Demo3 {
    public static void main(String[] args) {
        try {
            String path = "com.xinwu.javalearning.reflection.bean.User";
            Class clazz = Class.forName(path);

            System.out.println("通过反射创建对象");
            User u1 = (User) clazz.newInstance(); //调用类的无参构造器，许多框架的实现都是通过此方法创建对象
            System.out.println(u1);
            Constructor<User> constructor = clazz.getDeclaredConstructor(Long.class, Integer.class, String.class);
            User u2 = constructor.newInstance(1L, 1, "james");
            System.out.println(u2);

            System.out.println();
            System.out.println("通过反射调用方法");
            User u3 = (User) clazz.newInstance();
            Method m1 = clazz.getDeclaredMethod("setId", Long.class);
            m1.invoke(u3, 2L);
            System.out.println(u3.getId());

            System.out.println();
            System.out.println("通过反射对属性操作");
            User u4 = (User) clazz.newInstance();
            Field idField = clazz.getDeclaredField("id");
            idField.setAccessible(true);  //跳过安全检查，通过此方法可对私有属性设值
            idField.set(u4, 3L);
            System.out.println(u4.getId());
            System.out.println(idField.get(u4));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
