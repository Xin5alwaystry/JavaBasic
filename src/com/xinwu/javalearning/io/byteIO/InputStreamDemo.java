package com.xinwu.javalearning.io.byteIO;

import java.io.*;

public class InputStreamDemo {
    public static void main(String[] args) {
        //1、确定对象
        File file = new File("/Users/xin5/Desktop/develop/testdir/test.txt");
        InputStream is = null;
        try {
            //2、建立连接
            is = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int size;
            //3、操作
            while(-1!=(size=is.read(buf))) {
                String s = new String(buf, 0, size);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        } finally {
            if (null != is) {
                try {
                    //4、释放资源
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
