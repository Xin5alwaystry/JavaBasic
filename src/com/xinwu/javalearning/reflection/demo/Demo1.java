package com.xinwu.javalearning.reflection.demo;

import com.xinwu.javalearning.reflection.bean.User;
//Java中任何东西都有Class对象，包括的8大基本数据类型；
//需注意的是，同类型同维度的数组公用同一个Class对象
//获取Class对象的各种方式
public class Demo1 {
    public static void main(String[] args) {
        String path = "com.xinwu.javalearning.reflection.bean.User";
        try {
            //1,通过Class.forName()获取
            Class clazz = Class.forName(path);
            System.out.println(clazz.hashCode());
            //2,通过实例的getClass()方法获取
            User user = new User();
            Class clazz2 = user.getClass();
            System.out.println(clazz2.hashCode());
            //3,通过类.class获取
            Class clazz3 = User.class;
            System.out.println(clazz3.hashCode());
            //通过以上的例子可知，一个类加载后，只有唯一的Class对象，类似单例
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
