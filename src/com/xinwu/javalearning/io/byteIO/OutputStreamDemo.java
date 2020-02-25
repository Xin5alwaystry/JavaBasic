package com.xinwu.javalearning.io.byteIO;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("/Users/xin5/Desktop/develop/testdir/test.txt");
        OutputStream os = null;
        try {
            //new FileOutputStream(file, true) true为追加，false为覆盖。默认为覆盖
            os = new FileOutputStream(file, true);
            String s = "test outputStream.\r\n";
            byte[] bytes = s.getBytes();
            os.write(bytes, 0, bytes.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败");
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
