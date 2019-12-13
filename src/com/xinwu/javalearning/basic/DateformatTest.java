package com.xinwu.javalearning.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 练习DateFormat
 */
public class DateformatTest {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        //format 把Date对象按照格式转化为字符串
        System.out.println(dateFormat.format(date));

        String time = "1992-10-10";
        try {
            //parse 把特定格式的时间字符串转成Date对象
            Date timeDate = dateFormat.parse(time);
            System.out.println(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
