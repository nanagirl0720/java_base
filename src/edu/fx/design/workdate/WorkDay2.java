package edu.fx.design.workdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Pxn
 * @date: 2019/11/26 23:07
 */
public class WorkDay2 {

    /**
     * <p>Title: main </P>
     * <p>Description: TODO </P>
     */
    public static void main(String[] args) {
        try {


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            //转正的的时间
            Date formalDate = df.parse("2018-05-08");

            Calendar ca = Calendar.getInstance();
            //需要计算薪资的月份
            Date d = df.parse("2018-05-01");
            ca.setTime(d);//设置当前时间


            //计算这个月共有多少天
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2018);
            cal.set(Calendar.MONTH, 4);
            int maxDate = cal.getActualMaximum(Calendar.DATE);

            //增加法定节假日
            List<String> noWorkDate = new ArrayList<String>();
            noWorkDate.add("2018-05-01");
            initHolidayList(noWorkDate);


            List<Date> dates = addDateByWorkDay(ca, maxDate);
            int count = 0;
            int total = 0;
            for (Date date : dates) {
                if (date.getTime() < formalDate.getTime()) {
                    count++;
                }
                total++;
                System.out.println(df.format(date));
            }
            System.out.println(count + "---实习的时间");
            System.out.println(total + "---这个月工作日总天数");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    private static List<Calendar> holidayList = new ArrayList<Calendar>();  //节假日列表

    /**
     * <p>Title: addDateByWorkDay </P>
     * <p>Description: TODO  计算相加day天，并且排除节假日和周末后的日期</P>
     *
     * @param calendar 当前的日期
     * @param day      相加天数
     * @return return  List<Date>    返回类型   返回这个月的所有的工作日
     */
    public static List<Date> addDateByWorkDay(Calendar calendar, int day) {
        List<Date> dates = new ArrayList<Date>();
        try {
            for (int i = 0; i < day; i++) {
                if (i == 0) {
                    calendar.add(Calendar.DAY_OF_MONTH, 0);
                } else {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }

                Date date = checkHoliday(calendar);
                if (date != null) {
                    dates.add(date);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }

    /**
     * <p>Title: checkHoliday </P>
     * <p>Description: TODO 验证日期是否是节假日</P>
     *
     * @param calendar 传入需要验证的日期
     * @return return Date    返回类型  返回null是节假日，返回 calendar.getTime()不是节假日
     */
    public static Date checkHoliday(Calendar calendar) throws Exception {
        //判断日期是否是周六周日
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return null;
        }
        //判断日期是否是节假日
        for (Calendar ca : holidayList) {
            if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
                    ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                return null;
            }
        }
//    System.out.println(calendar.getTime());
        return calendar.getTime();
    }

    /**
     * <p>Title: initHolidayList </P>
     * <p>Description: TODO  把所有节假日放入list，验证前要先执行这个方法</P>
     *
     * @param date 从数据库查 查出来的格式2014-05-09
     *             return void    返回类型
     */
    public static void initHolidayList(List<String> date) {

        for (String string : date) {

            String[] da = string.split("-");

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
            calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);// 月份比正常小1,0代表一月
            calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
            holidayList.add(calendar);
        }

    }

}
