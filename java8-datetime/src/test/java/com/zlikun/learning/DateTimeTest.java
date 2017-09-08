package com.zlikun.learning;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/8 10:37
 */
public class DateTimeTest {

    @Test
    public void test() {

        // Legacy -> New -> Legacy
        Calendar calendar = Calendar.getInstance() ;
        Instant i = calendar.toInstant() ;
        Date date = Date.from(i) ;

        // New -> Legacy -> New
        ZonedDateTime zdt = ZonedDateTime.parse("2014-02-24T11:17:00+01:00[Europe/Gibraltar]") ;
        GregorianCalendar gc = GregorianCalendar.from(zdt) ;
        LocalDateTime ldt = gc.toZonedDateTime().toLocalDateTime() ;

        // 下面测试针对：2017-9-8 成立
        Year year = Year.now() ;
        Assert.assertEquals(2017 ,year.getValue());

        YearMonth month = YearMonth.now() ;
        Assert.assertEquals(9 ,month.getMonthValue());

        Month month2 = Month.of(7) ;
        Assert.assertEquals(7 ,month2.getValue());

        MonthDay day = MonthDay.now() ;
        Assert.assertEquals(8 ,day.getDayOfMonth());
        Assert.assertEquals(9 ,day.getMonthValue());

        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY ;
        Assert.assertEquals(5 ,dayOfWeek.getValue());

        Duration duration = Duration.between(LocalTime.of(10 ,27) ,LocalTime.of(10 ,36)) ;
        // PT9M ???
        System.out.println(duration.abs());
        // 540
        System.out.println(duration.getSeconds());

        Period period = Period.of(2017 ,7 ,14) ;
        System.out.println(period.getDays());   // 14
        System.out.println(period.getMonths()); // 7
        System.out.println(period.getYears());  // 2017

        Clock clock = Clock.systemUTC() ;
        // 2017-09-08T03:03:38.549Z
        System.out.println(clock.instant().toString());

    }

    @Test
    public void usage() {

        // 表示时间轴上的瞬时点，从：1970-01-01T00:00:00Z 起算
        Instant instant = Instant.now() ;
        // 1504838939
        System.out.println(instant.getEpochSecond());
        // 13000000
        System.out.println(instant.getNano());

        // 不可变日期
        LocalDate ld = LocalDate.now() ;
        // 2017-09-08
        System.out.println(ld.toString());

        // 不可变时间
        LocalTime lt = LocalTime.now() ;
        // 10:50:27.183
        System.out.println(lt.toString());

        // 不可变日期时间
        LocalDateTime ldt = LocalDateTime.now() ;
        // 2017-09-08T10:51:49.038
        System.out.println(ldt.toString());

        // 下面的API待研究
//        OffsetTime ot = OffsetTime.now() ;
//        OffsetDateTime odt = OffsetDateTime.now() ;
//        ZonedDateTime zdt = ZonedDateTime.now() ;
//        ZoneOffset zo = ZoneOffset.of(null) ;
//        ZoneId zi = ZoneId.of(null) ;


    }

}
