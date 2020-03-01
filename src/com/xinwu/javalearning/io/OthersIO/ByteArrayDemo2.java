package com.xinwu.javalearning.io.OthersIO;


import java.io.*;

public class ByteArrayDemo2 {
    public static void main(String[] args) {
        String srcPath = "/Users/xin5/Desktop/develop/testdir/test.txt";
        String destPath = "/Users/xin5/Desktop/develop/testdir/test2.txt";
        try {
            write(read(srcPath), destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] read(String srcPath) throws IOException {
        //确定来源
        File src = new File(srcPath);
        //目的地
        byte[] dest;
        //确定流类型
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while(-1 != (len = is.read(buf))) {
            bos.write(buf, 0, len);
        }
        //使用输出流的时候，养成flush的好习惯
        bos.flush();
        dest = bos.toByteArray();
        //关闭资源
        bos.close();
        is.close();

        return dest;
    }

    private static void write(byte[] bytes, String destPath) throws IOException {
        //确定来源bytes
        //目的地文件夹路径
        File dest = new File(destPath);
        //选择流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        os.write(bytes, 0, bytes.length);
        os.flush();
        os.close();
    }
}
