package com.test.study.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @PACKAGE_NAME: com.jing.rui.study.java8
 * @USER: xujingrui3
 * @DATE: 2019/10/15
 **/
public class Java8DateMain {
    public static void main(String[] args) {

        //https://www.jianshu.com/p/0bf8fe0f153b

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        // legacy java.util.Date
        Date legacyDate = Date.from(instant);

        System.out.println(ZoneId.getAvailableZoneIds());
// prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

/*
 ZoneRules[currentStandardOffset=+01:00]
 ZoneRules[currentStandardOffset=-03:00]
*/
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        // 13:37
        System.out.println(leetTime);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();

        System.out.println(dayOfWeek);    // FRIDAY

        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
        System.out.println(xmas);   // 2014-12-24

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439

        Instant instant1 = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate1 = Date.from(instant1);
        System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014

        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);     // Nov 03, 2014 - 07:13
    }
}
