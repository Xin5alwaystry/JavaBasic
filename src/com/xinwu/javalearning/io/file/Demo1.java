package com.xinwu.javalearning.io.file;

import java.io.File;

/**
 * File的两个常量，使用静态常量可以跨平台。
 */
public class Demo1 {
    public static void main(String[] args) {
        //路径分隔符
        System.out.println(File.pathSeparator);
        //文件分隔符
        System.out.println(File.separator);
    }
}
