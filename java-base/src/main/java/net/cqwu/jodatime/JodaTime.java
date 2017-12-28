package net.cqwu.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.Date;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.jodatime
 *
 * @author： Administrator
 * Create Date：  2017-12-28
 * Modified By：   Administrator
 * Modified Date:  2017-12-28
 * Why & What is modified
 * Version:        V1.0
 */
public class JodaTime {
    public static void main(String[] args) {
        DateTime dt = new DateTime(2017,12,28,12,43,22);
        System.out.println(dt.toString("yyyy-MM-dd"));
        System.out.println(dt.plusDays(1));
        System.out.println(dt.plusDays(-1));
        Date d = dt.toDate();
        System.out.println(d);

        DateTime dt1 = new DateTime("2017-12-27");
        DateTime dt2 = new DateTime("2017-12-28");
        Duration duration = new Duration(dt1,dt2);
        System.out.println(duration.getStandardDays());
    }
}
