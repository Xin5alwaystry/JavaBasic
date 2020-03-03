package com.xinwu.javalearning.io.OthersIO;

import java.io.*;

/**
 * ObjectInputStream & ObjectOutputStream
 * 1、必须先序列化后反序列化；反序列化顺序必须与序列化顺序一致
 * 2、不是所有对象都可以序列化，需要实现Serializable接口；
 *  并不是对象的所有属性都必须序列化，无需序列化的字段可用transient关键字修饰
 */
public class ObjectDemo {
    public static void main(String[] args) {
        String destPath = "/Users/xin5/Desktop/develop/testdir/object";
        try {
            writeData(destPath);
            readData(destPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readData(String srcPath) throws IOException, ClassNotFoundException {
        //确定数据源
        File src = new File(srcPath);
        //确定流
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));
        Object object = dis.readObject();

        if (object instanceof Employee) {
            System.out.println(object);
        }
    }

    public static void writeData(String destPath) throws IOException {
        //选择目的地
        File dest = new File(destPath);
        //创建数据源
        Employee employee = new Employee();
        employee.setName("lebron");
        employee.setSalary(10000);
        employee.setUnneccesary("does not important");

        //选择流
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
        //写出数据，读取的数据应与写入数据保持一致
        dos.writeObject(employee);

        dos.flush();
        dos.close();
    }
}
