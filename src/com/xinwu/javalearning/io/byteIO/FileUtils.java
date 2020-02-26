package com.xinwu.javalearning.io.byteIO;

import java.io.*;

public class FileUtils {
    /**
     *
     * @param srcPath 源文件绝对路径
     * @param destPath 目标文件绝对路径
     * @throws IOException
     */
    public static void copyFile(String srcPath, String destPath) throws IOException {
        File src = new File(srcPath);
        File dest = new File(destPath);
        copyFileDetail(src, dest);
    }

    /**
     *
     * @param src 源文件
     * @param dest 目标文件
     * @throws IOException
     */
    public static void copyFile(File src, File dest) throws IOException {
        copyFileDetail(src, dest);
    }

    public static void copyFileDetail(File src, File dest) throws IOException {
        if (!src.isFile()) {
            throw new IOException("文件夹不可拷贝");
        }
        if (dest.isDirectory()) {
            //文件夹不能覆盖
            throw new IOException("不能建立与文件夹同名的文件");
        }
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
        byte[] buf = new byte[1024];
        int size;
        while(-1!=(size=is.read(buf))) {
            os.write(buf, 0, size);
        }
        os.flush();

        os.close();
        is.close();
    }

    /**
     * 拷贝文件夹
     * @param src 源文件
     * @param dest 目标文件
     */
    public static void copyDir(File src, File dest) {
        if (src.isDirectory()) {
            //如果源文件是个文件夹，在目标文件中创建一名称与源文件相同的文件夹
            dest = new File(dest, src.getName());
        }
        copyDirDetail(src, dest);
    }

    public static void copyDir(String srcPath, String destPath) {
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
