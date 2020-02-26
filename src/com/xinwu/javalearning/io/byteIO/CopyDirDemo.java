package com.xinwu.javalearning.io.byteIO;

import java.io.File;
import java.io.IOException;

public class CopyDirDemo {
    public static void main(String[] args) {
        String srcPath = "/Users/xin5/Desktop/develop/testdir";
        String destPath = "/Users/xin5/Desktop/develop/study";

        File src = new File(srcPath);
        File dest = new File(destPath);

        copyDir(src, dest);
    }

    /**
     * 拷贝文件夹
     * @param src 源文件
     * @param dest 目标文件
     */
    private static void copyDir(File src, File dest) {
        if (src.isDirectory()) {
            //如果源文件是个文件夹，在目标文件中创建一名称与源文件相同的文件夹
            dest = new File(dest, src.getName());
        }
        copyDirDetail(src, dest);
    }

    private static void copyDir(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        if (src.isDirectory()) {
            //如果源文件是个文件夹，在目标文件中创建一名称与源文件相同的文件夹
            dest = new File(dest, src.getName());
        }
        copyDirDetail(src, dest);
    }

    /**
     * 拷贝文件夹细节
     * @param src
     * @param dest
     */
    private static void copyDirDetail(File src, File dest) {
        if (src.isFile()) {
            try {
                //如果源文件是个文件，直接文件拷贝
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (src.isDirectory()) {
            //否则，先保证目标文件夹创建完成；然后进行递归。
            dest.mkdirs();
            for (File file : src.listFiles()) {
                copyDirDetail(file, new File(dest, file.getName()));
            }
        }
    }
}
