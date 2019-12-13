package com.xinwu.javalearning.basic;

import java.io.File;

/**
 * 利用递归打印文件夹树状结构
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("/Users/xin5/Desktop/huntJob");
        printFile(file, 0);
    }

    public static void printFile(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                printFile(f, level + 1);
            }
        }
    }
}
