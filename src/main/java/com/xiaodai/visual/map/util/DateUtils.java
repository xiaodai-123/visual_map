package com.xiaodai.visual.map.util;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 日期相关处理<p>
 *
 * @author xiaozhameng
 */
public class DateUtils {

    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyyMMddHH";

    public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DATE_FORMAT_YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_YYYYMMDD_WORD = "yyyy年MM月dd日";

    public static final String DATE_FORMAT_YYYY_MM_DD_SLASH = "yyyy/MM/dd";

    private DateUtils() {
    }

    /**
     * 将指定格式的日期字符串转化为日期对象
     *
     * @param dateString   时间字符串
     * @param formatString 时间格式字符串
     */
    public static Date getDateFromString(String dateString, String formatString) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(formatString);
        return DateTime.parse(dateString, formatter).toDate();
    }

    /**
     * 将日期类型按照指定的格式转化为字符串
     *
     * @param date         时间字符串
     * @param formatString 时间格式字符串
     */
    public static String formatToString(Date date, String formatString) {
        if (date == null) {
            return "";
        }
        DateTime dt = new DateTime(date);
        return dt.toString(formatString);
    }

    /**
     * 两日期相差秒
     */
    public static long secondsBetween(Date startDate, Date endDate) {
        return (new Duration(new DateTime(startDate), new DateTime(endDate))).getStandardSeconds();
    }

    /**
     * 两日期相差分
     */
    public static long minutesBetween(Date startDate, Date endDate) {
        return (new Duration(new DateTime(startDate), new DateTime(endDate))).getStandardMinutes();
    }

    /**
     * 两日期相差小时
     */
    public static long hoursBetween(Date startDate, Date endDate) {
        return (new Duration(new DateTime(startDate), new DateTime(endDate))).getStandardHours();
    }

    /**
     * 两日期相差天数
     */
    public static long daysBetween(Date startDate, Date endDate) {
        return (new Duration(new DateTime(startDate), new DateTime(endDate))).getStandardDays();
    }

    /**
     * 获取前多少秒的日期
     */
    public static Date getBeforeSeconds(Date date, int seconds) {
        return new DateTime(date).minusSeconds(seconds).toDate();
    }

    /**
     * 获取前多少分钟的日期
     */
    public static Date getBeforeMinutes(Date date, int minutes) {
        return new DateTime(date).minusMinutes(minutes).toDate();
    }

    /**
     * 获取前多少小时的日期
     */
    public static Date getBeforeHours(Date date, int hours) {
        return new DateTime(date).minusHours(hours).toDate();
    }

    /**
     * 获取前多少天的日期
     */
    public static Date getBeforeDays(Date date, int days) {
        return new DateTime(date).minusDays(days).toDate();
    }

    /**
     * 获取前多少月的日期
     */
    public static Date getBeforeMonths(Date date, int months) {
        return new DateTime(date).minusMonths(months).toDate();
    }

    /**
     * 获取后多少秒的日期
     */
    public static Date getAfterSeconds(Date date, int seconds) {
        return new DateTime(date).plusSeconds(seconds).toDate();
    }

    /**
     * 获取后多少分钟的日期
     */
    public static Date getAfterMinutes(Date date, int minutes) {
        return new DateTime(date).plusMinutes(minutes).toDate();
    }

    /**
     * 获取后多少小时的日期
     */
    public static Date getAfterHours(Date date, int hours) {
        return new DateTime(date).plusHours(hours).toDate();
    }

    /**
     * 获取后多少天的日期
     */
    public static Date getAfterDays(Date date, int days) {
        return new DateTime(date).plusDays(days).toDate();
    }

    /**
     * 获取后多少月的日期
     */
    public static Date getAfterMonths(Date date, int months) {
        return new DateTime(date).plusMonths(months).toDate();
    }

    /**
     * 获取月的第一天
     *
     * @return YYYY-MM-DD
     */
    public static String getFirstDayOfMoth(Date date) {
        return (new DateTime(date)).dayOfMonth().withMinimumValue().toString(DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     * 获取月的最后一天
     */
    public static String getLastDayOfMoth(Date date) {
        return (new DateTime(date)).dayOfMonth().withMaximumValue().toString(DATE_FORMAT_YYYY_MM_DD);
    }
}
