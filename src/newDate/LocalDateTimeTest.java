package newDate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    /**
     * 日期时间格式
     */
    @Test
    public void test6(){
        LocalDateTime ldt = LocalDateTime.now();
       /* DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        String s = df.format(ldt);
        System.out.println(s);*/

        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String s2 = df2.format(ldt);
        System.out.println(s2);

        //字符串转日期
//        String ss = "2020/11/11";
        LocalDate ldt2 = LocalDate.parse(s2, df2);
//        LocalDateTime ldt3 = df2.parse(ss);
        System.out.println(ldt2);

//        LocalTime.parse

        String dateStr= "2018-06-20";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateTime = LocalDate.parse(dateStr, dateTimeFormatter);
        System.out.println(localDateTime);


        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);
        System.out.println(localDateTime1);


        System.out.println(Clock.systemDefaultZone());
    }

    /**
     * 测试localdatetime, 其他的localdate, localtime同
     */
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.plusMonths(1);
        //不可变，ldt没有变化
        System.out.println(ldt);
        System.out.println(ldt2);

        //时间间隔
        System.out.println(Duration.between(ldt, ldt2).toDays());

        //日期间隔
        LocalDate dt = LocalDate.now();
        LocalDate dt2 = dt.plusMonths(1);
        System.out.println(Period.between(dt, dt2).getYears());

    }
}
