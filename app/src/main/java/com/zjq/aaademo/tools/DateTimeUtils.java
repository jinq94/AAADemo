package com.zjq.aaademo.tools;


import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateTimeUtils {
    public static final DateTimeFormatter datetimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    public static final DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("HH:mm:ss");
    public static final DateTimeFormatter datetimeLongFormatter = DateTimeFormat.forPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter dateLongFormatter = DateTimeFormat.forPattern("yyyyMMdd");
    public static final DateTimeFormatter timeLongFormatter = DateTimeFormat.forPattern("HHmmss");

    private DateTimeUtils() {
    }

    public static Date now() {
        return new Date();
    }

    public static String currentDatetime() {
        return (new DateTime()).toString(datetimeFormatter);
    }

    public static String currentLongDatetime() {
        return (new DateTime()).toString(datetimeLongFormatter);
    }

    public static String formatDatetime(Date src) {
        return (new DateTime(src)).toString(datetimeFormatter);
    }

    public static Date parseDatetime(String src) {
        return DateTime.parse(src, datetimeFormatter).toDate();
    }

    public static String currentDate() {
        return (new DateTime()).toString(dateFormatter);
    }

    public static String currentLongDate() {
        return (new DateTime()).toString(dateLongFormatter);
    }

    public static String formatDate(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(dateFormatter);
    }

    public static Date parseDate(String src) {
        return DateTime.parse(src, dateFormatter).toDate();
    }

    public static String currentTime() {
        return (new DateTime()).toString(timeFormatter);
    }

    public static String currentLongTime() {
        return (new DateTime()).toString(timeLongFormatter);
    }

    public static String formatTime(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(timeFormatter);
    }

    public static Date parseTime(String src) {
        return DateTime.parse(src, timeFormatter).toDate();
    }

    public static String format(String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        DateTime dateTime = new DateTime();
        return dateTime.toString(format);
    }

    public static String format(Date date, String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

    public static Date parse(String src, String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(src, format).toDate();
    }

    public static boolean validatePattern(String src, String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);

        try {
            DateTime.parse(src, format);
            return true;
        } catch (IllegalFieldValueException var4) {
            return false;
        }
    }

    public static Date dateOfPlusSeconds(int seconds) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusSeconds(seconds);
        return dateTime.toDate();
    }

    public static Date dateOfPlusSeconds(Date src, int seconds) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.plusSeconds(seconds);
        return dateTime.toDate();
    }

    public static String datetimeStrOfPlusSeconds(int seconds) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusSeconds(seconds);
        return dateTime.toString(datetimeFormatter);
    }

    public static String datetimeStrOfPlusSeconds(String src, int seconds) {
        DateTime dateTime = DateTime.parse(src, datetimeFormatter);
        dateTime = dateTime.plusSeconds(seconds);
        return dateTime.toString(datetimeFormatter);
    }

    public static String timeStrOfPlusSeconds(int seconds) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusSeconds(seconds);
        return dateTime.toString(timeFormatter);
    }

    public static String timeStrOfPlusSeconds(String src, int seconds) {
        DateTime dateTime = DateTime.parse(src, timeFormatter);
        dateTime = dateTime.plusSeconds(seconds);
        return dateTime.toString(timeFormatter);
    }

    public static Date dateOfPlusMinutes(int minutes) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.toDate();
    }

    public static Date dateOfPlusMinutes(Date src, int minutes) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.toDate();
    }

    public static String datetimeStrOfPlusMinutes(int minutes) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.toString(datetimeFormatter);
    }

    public static String datetimeStrOfPlusMinutes(String src, int minutes) {
        DateTime dateTime = DateTime.parse(src, datetimeFormatter);
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.toString(datetimeFormatter);
    }

    public static String timeStrOfPlusMinutes(int minutes) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.toString(timeFormatter);
    }

    public static String timeStrOfPlusMinutes(String src, int minutes) {
        DateTime dateTime = DateTime.parse(src, timeFormatter);
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.toString(timeFormatter);
    }

    public static Date dateOfPlusHours(int hours) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusHours(hours);
        return dateTime.toDate();
    }

    public static Date dateOfPlusHours(Date src, int hours) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.plusHours(hours);
        return dateTime.toDate();
    }

    public static String datetimeStrOfPlusHours(int hours) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusHours(hours);
        return dateTime.toString(datetimeFormatter);
    }

    public static String datetimeStrOfPlusHours(String src, int hours) {
        DateTime dateTime = DateTime.parse(src, datetimeFormatter);
        dateTime = dateTime.plusHours(hours);
        return dateTime.toString(datetimeFormatter);
    }

    public static String timeStrOfPlusHours(int hours) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusHours(hours);
        return dateTime.toString(timeFormatter);
    }

    public static String timeStrOfPlusHours(String src, int hours) {
        DateTime dateTime = DateTime.parse(src, timeFormatter);
        dateTime = dateTime.plusHours(hours);
        return dateTime.toString(timeFormatter);
    }

    public static Date dateOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static Date dateOfPlusDays(Date src, int days) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static String datetimeStrOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(dateFormatter);
    }

    public static String datetimeStrOfPlusDays(String src, int days) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(dateFormatter);
    }

    public static String dateStrOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(dateFormatter);
    }

    public static String dateStrOfPlusDays(String src, int days) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(dateFormatter);
    }

    public static Date dateOfPlusMonths(int months) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(months);
        return dateTime.toDate();
    }

    public static Date dateOfPlusMonths(Date src, int months) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.plusMonths(months);
        return dateTime.toDate();
    }

    public static String datetimeStrOfPlusMonths(int months) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(months);
        return dateTime.toString(dateFormatter);
    }

    public static String datetimeStrOfPlusMonths(String src, int months) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        dateTime = dateTime.plusMonths(months);
        return dateTime.toString(dateFormatter);
    }

    public static String dateStrOfPlusMonths(int months) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(months);
        return dateTime.toString(dateFormatter);
    }

    public static String dateStrOfPlusMonths(String src, int months) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        dateTime = dateTime.plusMonths(months);
        return dateTime.toString(dateFormatter);
    }

    public static Date dateOfPlusYears(int years) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusYears(years);
        return dateTime.toDate();
    }

    public static Date dateOfPlusYears(Date src, int years) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.plusYears(years);
        return dateTime.toDate();
    }

    public static String datetimeStrOfPlusYears(int years) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusYears(years);
        return dateTime.toString(dateFormatter);
    }

    public static String datetimeStrOfPlusYears(String src, int years) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        dateTime = dateTime.plusYears(years);
        return dateTime.toString(dateFormatter);
    }

    public static String dateStrOfPlusYears(int years) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusYears(years);
        return dateTime.toString(dateFormatter);
    }

    public static String dateStrOfPlusYears(String src, int years) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        dateTime = dateTime.plusYears(years);
        return dateTime.toString(dateFormatter);
    }

    public static String datetimeStrOfWithSecond(int second) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withSecondOfMinute(second);
        return dateTime.toString(datetimeFormatter);
    }

    public static String timeStrOfWithDay(int second) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withSecondOfMinute(second);
        return dateTime.toString(timeFormatter);
    }

    public static String datetimeStrOfWithMinute(int minute) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withMinuteOfHour(minute);
        return dateTime.toString(datetimeFormatter);
    }

    public static String dateStrOfWithMinute(int minute) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withMinuteOfHour(minute);
        return dateTime.toString(timeFormatter);
    }

    public static String datetimeStrOfWithHour(int hour) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withHourOfDay(hour);
        return dateTime.toString(datetimeFormatter);
    }

    public static String timeStrOfWithHour(int hour) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withHourOfDay(hour);
        return dateTime.toString(timeFormatter);
    }

    public static String datetimeStrOfWithDay(int day) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withDayOfMonth(day);
        return dateTime.toString(datetimeFormatter);
    }

    public static String dateStrOfWithDay(int day) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withDayOfMonth(day);
        return dateTime.toString(dateFormatter);
    }

    public static String datetimeStrOfWithMonth(int month) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withMonthOfYear(month);
        return dateTime.toString(datetimeFormatter);
    }

    public static String dateStrOfWithMonth(int month) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withMonthOfYear(month);
        return dateTime.toString(dateFormatter);
    }

    public static String datetimeStrOfWithYear(int year) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withYear(year);
        return dateTime.toString(datetimeFormatter);
    }

    public static String dateStrOfWithYear(int year) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.withYear(year);
        return dateTime.toString(dateFormatter);
    }

    public static Calendar calendar() {
        DateTime dateTime = new DateTime();
        return dateTime.toCalendar(Locale.CHINESE);
    }

    public static long millis() {
        return System.currentTimeMillis();
    }

    public static Long seconds() {
        return millis() / 1000L;
    }

    public static int year() {
        return (new DateTime()).getYear();
    }

    public static int monthOfYear() {
        return (new DateTime()).getMonthOfYear();
    }

    public static int dayOfMonth() {
        return (new DateTime()).getDayOfMonth();
    }

    public static int dayOfWeek() {
        return (new DateTime()).getDayOfWeek();
    }

    public static int hourOfDay() {
        return (new DateTime()).getHourOfDay();
    }

    public static int minuteOfHour() {
        return (new DateTime()).getMinuteOfHour();
    }

    public static int secondOfMinute() {
        return (new DateTime()).getSecondOfMinute();
    }

    public static String week() {
        DateTime dateTime = new DateTime();
        switch (dateTime.getDayOfWeek()) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            default:
                return "日";
        }
    }

    public static String week(String src) {
        DateTime dateTime = DateTime.parse(src, dateFormatter);
        switch (dateTime.getDayOfWeek()) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            default:
                return "日";
        }
    }

    public static boolean isBefore(Date src) {
        return src.before(new Date());
    }

    public static boolean isBefore(Date src, Date dst) {
        return src.before(dst);
    }

    public static boolean isBefore(String src) {
        DateTime dateTimeSrc = new DateTime(src);
        DateTime dateTimeDst = new DateTime();
        dateTimeDst = dateTimeDst.dayOfMonth().roundFloorCopy();
        return dateTimeSrc.isBefore(dateTimeDst);
    }

    public static boolean isBefore(String src, String dst) {
        DateTime dateTimeSrc = new DateTime(src);
        DateTime dateTimeDst = new DateTime(dst);
        return dateTimeSrc.isBefore(dateTimeDst);
    }

    public static boolean isAfter(Date src) {
        Date dst = new Date();
        return src.after(dst);
    }

    public static boolean isAfter(Date src, Date dst) {
        return src.after(dst);
    }

    public static boolean isAfter(String src) {
        DateTime dateTimeSrc = new DateTime(src);
        DateTime dateTimeDst = new DateTime();
        dateTimeDst = dateTimeDst.dayOfMonth().roundFloorCopy();
        return dateTimeSrc.isAfter(dateTimeDst);
    }

    public static boolean isAfter(String src, String dst) {
        DateTime dateTimeSrc = new DateTime(src);
        DateTime dateTimeDst = new DateTime(dst);
        return dateTimeSrc.isAfter(dateTimeDst);
    }

    public static boolean isEqual(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }

    public static boolean between(Date beginDate, Date endDate, Date src) {
        return beginDate.before(src) && endDate.after(src);
    }

    public static Date lastTimeOfDay() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1);
        dateTime = dateTime.minusMillis(1);
        return dateTime.toDate();
    }

    public static Date lastTimeOfDay(Date src) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1);
        dateTime = dateTime.minusMillis(1);
        return dateTime.toDate();
    }

    public static Date lastTimeOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1);
        dateTime = dateTime.minusMillis(1);
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static Date lastTimeOfPlusDays(Date src, int days) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1);
        dateTime = dateTime.minusMillis(1);
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static Date lastTimeOfDay(String src) {
        DateTime dateTime = DateTime.parse(src);
        dateTime = dateTime.plusDays(1).minusMillis(1);
        return dateTime.toDate();
    }

    public static Date lastTimeOfPlusDays(String src, int days) {
        DateTime dateTime = DateTime.parse(src);
        dateTime = dateTime.plusDays(1).minusMillis(1);
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static String lastTimeStrOfDay() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1);
        dateTime = dateTime.minusMillis(1);
        return dateTime.toString(timeFormatter);
    }

    public static String lastDatetimeStrOfDay() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1).minusMillis(1);
        return dateTime.toString(datetimeFormatter);
    }

    public static String lastDatetimeStrOfDay(String date) {
        DateTime dateTime = DateTime.parse(date);
        dateTime = dateTime.plusDays(1).minusMillis(1);
        return dateTime.toString(datetimeFormatter);
    }

    public static String lastDatetimeStrOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(1).minusMillis(1);
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(datetimeFormatter);
    }

    public static String lastDatetimeStrOfPlusDays(String date, int days) {
        DateTime dateTime = DateTime.parse(date);
        dateTime = dateTime.plusDays(1).minusMillis(1);
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(datetimeFormatter);
    }

    public static Date firstTimeOfDay() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        return dateTime.toDate();
    }

    public static Date firstTimeOfDay(Date src) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        return dateTime.toDate();
    }

    public static Date firstTimeOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static Date firstTimeOfPlusDays(Date src, int days) {
        DateTime dateTime = new DateTime(src);
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static Date firstTimeOfDay(String src) {
        DateTime dateTime = DateTime.parse(src);
        return dateTime.toDate();
    }

    public static Date firstTimeOfPlusDays(String src, int days) {
        DateTime dateTime = DateTime.parse(src);
        dateTime = dateTime.plusDays(days);
        return dateTime.toDate();
    }

    public static String firstTimeStrOfDay() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        return dateTime.toString(timeFormatter);
    }

    public static String firstDatetimeStrOfDay() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        return dateTime.toString(datetimeFormatter);
    }

    public static String firstDatetimeStrOfDay(String date) {
        DateTime dateTime = DateTime.parse(date);
        return dateTime.toString(datetimeFormatter);
    }

    public static String firstDatetimeStrOfPlusDays(int days) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.dayOfMonth().roundFloorCopy();
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(datetimeFormatter);
    }

    public static String firstDatetimeStrOfPlusDays(String date, int days) {
        DateTime dateTime = DateTime.parse(date);
        dateTime = dateTime.plusDays(days);
        return dateTime.toString(datetimeFormatter);
    }

    public static Date lastDateOfMonth() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.monthOfYear().roundFloorCopy();
        dateTime = dateTime.plusMonths(1).minusMillis(1);
        return dateTime.toDate();
    }

    public static Date firstDateOfMonth() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.monthOfYear().roundFloorCopy();
        return dateTime.toDate();
    }
}
