package com.xinwu.javalearning.basic;

import java.util.Scanner;

public class ScannerTest {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请在键盘输入任意的字符串");
        String keyboredIn = scanner.next(); //此时程序会阻塞
        System.out.println(String.format("您在键盘输入的是：%s", keyboredIn));
    }

    public static void easyCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int a = scanner.nextInt();
        System.out.println("请输入另一个整数：");
        int b = scanner.nextInt();
        System.out.println(String.format("%s + %s = %s", a, b, a + b));
    }

    public static void main(String[] args) {
        easyCalculator();
    }

}
