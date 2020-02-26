package com.xinwu.javalearning.io.ProcessIO;

import java.io.*;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        //假设要拷贝的两个都是文件
        String srcPath = "/Users/xin5/Desktop/develop/testdir/test.txt";
        String destPath = "/Users/xin5/Desktop/develop/testdir/test1.txt";
        //copyFileByByte(srcPath, destPath);
        copyTextFileByChar(srcPath, destPath);
    }

    public static void copyFileByByte(String srcPath, String destPath) throws IOException {
        File src = new File(srcPath);
        File dest = new File(destPath);
        //用法跟字节节点流（InputStream,OutputStream一样，但效率更高，今后推荐使用）
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] buf = new byte[1024];
        int size;
        while(-1!=(size=bis.read(buf))) {
            bos.write(buf, 0, size);
        }
        bos.flush();

        bis.close();
        bos.close();
    }

    public static void copyTextFileByChar(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            writer = new BufferedWriter(new FileWriter(dest));
            String line;
            while (null!=(line=reader.readLine())) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush(); //jdk7后自动关闭流，可不用处理。哦耶～
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
