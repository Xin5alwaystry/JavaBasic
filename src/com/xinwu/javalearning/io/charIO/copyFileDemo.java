package com.xinwu.javalearning.io.charIO;

import java.io.*;

public class copyFileDemo {
    public static void main(String[] args) {
        String srcPath = "/Users/xin5/Desktop/develop/testdir/test.txt";
        String destPath = "/Users/xin5/Desktop/develop/testdir/test1.txt";
        File src = new File(srcPath);
        File dest = new File(destPath);
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(dest);
            char[] buf = new char[1024];
            int size;
            if (-1!=(size=reader.read(buf))) {
                writer.write(buf, 0, size);
            }
            writer.flush(); //jdk7后自动关闭流，可不用处理。哦耶～
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
