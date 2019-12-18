package com.xinwu.javalearning.generic.gen01;

/**
 * 泛型接口
 * 接口中泛型字母只能使用在方法中，不能使用在全局常量中，因为接口中的全局常量默认为static
 * @param <T>
 */
public interface Comparator<T> {
    int compare(T t);
}
