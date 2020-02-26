package com.xinwu.javalearning.io.convertIO;

import java.io.*;

/**
 * 转换流：InputStreamReader, OutputStreamWriter
 */
public class ConvertDemo {
    public static void main(String[] args) {
//        String srcPath = "/Users/xin5/Desktop/develop/testdir/test.txt";
//        try {
//            readFile(srcPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String destPath = "/Users/xin5/Desktop/develop/testdir/test2.txt";
        try {
            writeFile(destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String srcPath) throws IOException {
        //文件编码和解码的字符集应当一直，否则乱码
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(srcPath)), "utf-8"));
        String line;
        while (null != (line = br.readLine())) {
            System.out.println(line);
        }
        br.close();
    }

    public static void writeFile(String destPath) throws IOException {
        BufferedWriter bfw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(new File(destPath)), "utf-8"));
        bfw.write("锄禾日当午");
        bfw.flush();
        bfw.close();
    }
}
