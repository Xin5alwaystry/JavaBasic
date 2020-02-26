package com.xinwu.javalearning.io.byteIO;

import java.io.*;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        //假设要拷贝的两个都是文件
        String srcPath = "/Users/xin5/Desktop/develop/testdir/test.txt";
        String destPath = "/Users/xin5/Desktop/develop/testdir/test1.txt";
        File src = new File(srcPath);
        File dest = new File(destPath);
        InputStream is = new FileInputStream(src);;
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
}
