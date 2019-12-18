package com.xinwu.javalearning.generic.gen01;

public class  App {
    public static void main(String[] args) {
        //在使用时指定类型
        Student<String, Integer> student = new Student<>();
        //1，安全：类型检查
        student.setJava("java");
        student.setOracle(11);
        //2，省心：类型转换
        String java = student.getJava();
    }
}
