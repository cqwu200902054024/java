package net.cqwu.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.date
 *
 * @author： Administrator
 * Create Date：  2017-12-28
 * Modified By：   Administrator
 * Modified Date:  2017-12-28
 * Why & What is modified
 * Version:        V1.0
 */
public class DateUtil {
    public static void main(String[] args) {
        //通过工厂方法创建一个LocalDate对象，并读取其值
        LocalDate date = LocalDate.of(2017,12,28);
        System.out.println(date.getYear());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getMonth());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.lengthOfYear());
        System.out.println(date.isLeapYear());
        //从系统时钟中获取当前的日期
        LocalDate today = LocalDate.now();
        System.out.println(today);
        //
        LocalTime time = LocalTime.of(14,45,20);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        //通过格式化字符串创建
        date = LocalDate.parse("2017-12-28");
        time = LocalTime.parse("13:45:20");
        //你可以向parse方法传递一个DateTimeFormatter。该类的实例定义了如何格式化一个日
        //期或者时间对象。
        LocalDateTime dt = LocalDateTime.of(date,time);
        System.out.println(dt);
        LocalDateTime dt1 = date.atTime(time);
        System.out.println(dt1);
        LocalDateTime dt2 = time.atDate(date);
        System.out.println(dt2);
        //提取LocalDate和LocalTime
        date = dt2.toLocalDate();
        System.out.println(date);
        time = dt2.toLocalTime();
        System.out.println(time);
        //时间戳
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.now().getEpochSecond());
        //时间差
       LocalDate date1 = LocalDate.of(2017,12,23);
        LocalDate date2 = LocalDate.now();
       // Duration duration = Duration.between(date1,date2);
        LocalTime time1 = LocalTime.of(12,23,5);
        LocalTime time2 = LocalTime.of(12,26,56);
        System.out.println(Duration.between(time1,time2).toMinutes());
        System.out.println(Duration.between(time1.atDate(date1),time1.atDate(date2)).toDays());
        //如果你需要以年、月或者日的方式对多个时间单位建模，可以使用Period类
        System.out.println(Period.between(date1,date2).getDays());
         //withAttribute方法会创建对象的一个副本，并按照需要修改它的属
        //性。它们都不会修改原来的对象！
         LocalDate date3 = date1.withYear(2016);
        System.out.println(date1.getYear());
        System.out.println(date3.getYear());
       //使用的plus方法能非常方便地将Temporal对象前溯或者回滚至某个时间段
        LocalDate date4 = date2.plusDays(-1);
        System.out.println(date4.getDayOfMonth());
        date4 = date2.plusWeeks(1);
        System.out.println(date4.getYear());
        //将日期调整到下个周日、下个工作日，或者是本月的最后一天
        date = date2.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println(date.getDayOfMonth());
        System.out.println(date2.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
        //日期格式化
        String sDate = date2.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(sDate);
        sDate = date2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(sDate);
        sDate = date2.atTime(time).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(sDate);
    }
}
