package com.xinwu.javalearning.io.OthersIO;

import java.io.*;

/**
 * DataInputStream DataOutputStream 用于读取基本类型和String类型，写入和读取顺序需要相同
 */
public class DataDemo {
    public static void main(String[] args) {
        String destPath = "/Users/xin5/Desktop/develop/testdir/data";
        try {
            writeData(destPath);
            readData(destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(String srcPath) throws IOException {
        //确定数据源
        File src = new File(srcPath);
        //确定流
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(src)));
        boolean flag = dis.readBoolean();
        double pi = dis.readDouble();
        String test = dis.readUTF();

        System.out.println(String.format("%s--%s--%s", flag, pi, test));
    }

    public static void writeData(String destPath) throws IOException {
        //选择目的地
        File dest = new File(destPath);
        //创建数据源
        boolean flag = false;
        double pi = 3.14;
        String test = "测试";

        //选择流
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
        //写出数据，读取的数据应与写入数据保持一致
        dos.writeBoolean(flag);
        dos.writeDouble(pi);
        dos.writeUTF(test);

        dos.flush();
        dos.close();
    }
}
