package com.xinwu.javalearning.generic.gen01;

/**
 * 泛型类：声明类时使用范型
 * 约定俗成的字母： T type；K key；V value；E element
 * 在使用类时确定类型
 *
 * 类型：
 * 1，泛型只能使用引用类型，不能使用8大基本类型
 * 2，泛型声明时不能使用在静态属性或者静态方法上，因为它的类型在使用时才确定，静态属性等是在编译时确定的。
 *
 * @param <T1>
 * @param <T2>
 */
public class Student<T1, T2> {
    private T1 java;
    private T2 oracle;

    public T1 getJava() {
        return java;
    }

    public void setJava(T1 java) {
        this.java = java;
    }

    public T2 getOracle() {
        return oracle;
    }

    public void setOracle(T2 oracle) {
        this.oracle = oracle;
    }
}
