package edu.fx.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Pxn
 * @date: 2020/1/6 21:51
 */
public class DateTest {
    public static void main(String[] args) {
        //日期格式化(日期->字符串)
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        //解析(字符串->日期)
        String riqi="2020-01-06";
        Date birthDay=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDay = dateFormat.parse(riqi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date birth = new java.sql.Date(birthDay.getTime());
        System.out.println(birth);
    }
}
