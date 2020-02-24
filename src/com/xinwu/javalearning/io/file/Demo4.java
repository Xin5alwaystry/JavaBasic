package com.xinwu.javalearning.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件夹的基本操作
 */
public class Demo4 {
    public static void main(String[] args) {
        String parentPath = "/Users/xin5/Desktop/develop/study";
        File testDir = new File(parentPath);
        //testDir.mkdir(); //该方法需要父目录存在
        //testDir.mkdirs();  //该方法会创建整个目录链
        if (testDir.exists() && testDir.isDirectory()) {
            System.out.println("---输出子文件/子目录---");
            String[] fileNames = testDir.list();
            for (String name : fileNames
            ) {
                System.out.println(name);
            }

            System.out.println("---输出子文件/子目录File对象---");
            File[] files = testDir.listFiles();
            for (File file : files
            ) {
                System.out.println(file.getAbsolutePath());
            }

            System.out.println("---输出子文件/子目录File对象(带过滤器)---");
            File[] filterFiles = testDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith("study");
                }
            });
            for (File file : filterFiles
            ) {
                System.out.println(file.getAbsolutePath());
            }

            System.out.println("打印文件树：");
            //printName(testDir);

            System.out.println("获取所有跟路径");
            File[] rootFiles = File.listRoots();
            for (File rootFile : rootFiles
                 ) {
                System.out.println(rootFile.getAbsolutePath());
            }
        }
    }

    //递归打印文件夹树
    public static void printName(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File one : files
            ) {
                printName(one);
            }
        }
    }
}
