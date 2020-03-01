package com.xinwu.javalearning.io.OthersIO;


import java.io.*;

public class ByteArrayDemo {
    public static void main(String[] args) throws IOException {
        //read("武汉加油");
        write("武汉加油");
    }

    public static void write(String src) throws IOException {
        byte[] dest; //要到入的目的地
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] info = src.getBytes();  //准备源数据
        bos.write(info, 0, info.length);
        bos.close();

        //toByteArray 新增方法，因此不可使用多态。
        System.out.println(new String(bos.toByteArray()));
    }

    /**
     * 输入流，操作与文件输入流一致（读取方法一致，可以使用多态）
     * @param src
     * @throws IOException
     */
    public static void read(String src) throws IOException {
        //将该字符串所转的字节数组作为数据源头
        byte[] bytes = src.getBytes();  //以默认字符集编码(gbk)

        //1、选择流
        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(bytes)
        );
        byte[] buf = new byte[1024];
        int size;
        //2、读取流
        if ((-1!=(size=is.read(buf)))) {
            System.out.println(new String(bytes));
        }
        //3、释放资源
        is.close(); //ByteArrayInputStream的close方法无效，没有任何实现。
    }
}
