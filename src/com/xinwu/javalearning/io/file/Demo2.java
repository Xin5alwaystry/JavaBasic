package com.xinwu.javalearning.io.file;

import java.io.File;

/**
 * 以绝对路径和相对路径创建文件File
 */
public class Demo2 {
    // /Users/xin5/Desktop/testdir/test.txt
    public static void main(String[] args) {
        String absolutePath = "/Users/xin5/Desktop/develop/testdir/text.txt";
        String parentPath = "/Users/xin5/Desktop/develop/testdir";
        String fileName = "text.txt";
        //1,用绝对路径获取文件对象
        File a = new File(absolutePath);
        System.out.println(a.getName());
        System.out.println(a.getAbsolutePath());

        //2,用所在文件夹路径 + 文件名获取文件对象
        File b = new File(parentPath, fileName);
        System.out.println(b.getName());
        System.out.println(b.getAbsolutePath());

        //3,用文件所在文件夹的File对象 + 文件名称 获取文件对象
        //其实这些获取File对象的方式，也可直接查看源码
        File c = new File(new File(parentPath), fileName);
        System.out.println(c.getName());
        System.out.println(c.getAbsolutePath());

        File d = new File(fileName);
        System.out.println(d.getName());
        System.out.println(d.getAbsolutePath());
    }
}
