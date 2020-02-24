package com.xinwu.javalearning.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 文件的一些基本操作
 */
public class Demo3 {
    public static void main(String[] args) {
//        testName();
//        testFileInfo();
        testLength();
//        testCreate();
//        testDelete();
//        testTempFile();
    }


    //文件名。
    public static void testName() {
        String parentPath = "/Users/xin5/Desktop/develop/testdir/test.txt";
        File testFile = new File(parentPath); //输入完整路径名
        System.out.println(testFile.getName()); //获取文件名
        System.out.println(testFile.getPath()); //如果创建文件时提供绝对路径，则返回绝对路径；否者返回相对路径
        System.out.println(testFile.getAbsolutePath()); //获取文件绝对路径
        System.out.println(testFile.getParent()); //如果的以相对路径创建的文件，返回null；否则返回上一级目录的路径
    }

    public static void testFileInfo() {
        // String path = "1.txt";
        String path = "/Users/xin5/Desktop/develop/testdir/test.txt";
        File testFile = new File(path);
        System.out.println("文件是否存在：" + testFile.exists());
        System.out.println("文件是否可读：" + testFile.canRead());
        System.out.println("文件是否可写：" + testFile.canWrite());
        System.out.println("文件是否为文件夹：" + testFile.isDirectory());  //当文件不存在时，默认为文件夹
        System.out.println("文件是否为文件" + testFile.isFile());
        System.out.println("文件是否为绝对路径" + testFile.isAbsolute());
    }

    //文件的大小。文件为文件夹时，返回的数值不是文件夹大小，具体看参见源码
    public static void testLength() {
        //String path = "/Users/xin5/Desktop/develop/testdir/test.txt";
        String path = "/Users/xin5/Desktop/develop/testdir";
        File testFile = new File(path);
        System.out.println("文件大小为：" + testFile.length());
    }

    //文件的创建
    public static void testCreate() {
        String path = "/Users/xin5/Desktop/develop/testdir/test1.txt";
        File testFile = new File(path);
        if (!testFile.exists()) {
            try {
                testFile.createNewFile();  //文件不存在时，才会创建文件并返回true；否者返回false
            } catch (IOException e) {
                System.out.println("创建文件失败");
            }
        }
    }

    //文件的删除
    public static void testDelete() {
        String path = "/Users/xin5/Desktop/develop/testdir/test1.txt";
        File testFile = new File(path);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    //创建临时文件静态方法
    public static void testTempFile() {
        try {
            File testFile = File.createTempFile("test", ".tmp", new File("/Users/xin5/Desktop/develop/testdir"));
            Thread.sleep(5000);
            testFile.deleteOnExit(); //退出时删除临时文件
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
