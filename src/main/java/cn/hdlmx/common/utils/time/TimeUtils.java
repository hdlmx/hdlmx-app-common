
package cn.hdlmx.common.utils.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 基于Java 8 time API的时间工具
 *
 * @author hdlmx
 * @date 2022/04/03
 */
public class TimeUtils {
    /**
     * 一分钟的秒
     */
    private final static int SECONDS_OF_MINUTE = 60;
    /**
     * 一小时的秒
     */
    private final static int SECONDS_OF_HOUR = SECONDS_OF_MINUTE * 60;
    /**
     * 一天中的秒
     */
    private final static int SECONDS_OF_DAY = 24 * SECONDS_OF_HOUR;
    /**
     * 日期格式
     */
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * 时间格式
     */
    private final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 中国时区
     */
    private final static int CHINA_TIME_ZONE = 8;

    /**
     * 计算两个时间点的相差时间
     *
     * @param beginTime 开始时间
     * @return 时间间隔字符串
     */
    public static String timeDurationStr(LocalDateTime beginTime) {
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(beginTime, endTime);
        long secondsOfTime = Math.abs(duration.getSeconds());
        long day = 0L;
        long minutes = 0L;
        long hours = 0L;
        long seconds = 0L;
        if (secondsOfTime >= SECONDS_OF_DAY) {
            day = secondsOfTime / SECONDS_OF_DAY;
            secondsOfTime = secondsOfTime % SECONDS_OF_DAY;
        }
        if (secondsOfTime >= SECONDS_OF_HOUR) {
            hours = secondsOfTime / SECONDS_OF_HOUR;
            secondsOfTime = secondsOfTime % SECONDS_OF_HOUR;
        }
        if (secondsOfTime >= SECONDS_OF_MINUTE) {
            minutes = secondsOfTime / SECONDS_OF_MINUTE;
            secondsOfTime = secondsOfTime % SECONDS_OF_MINUTE;
        }
        seconds = secondsOfTime;
        return day + "天" + hours + "小时" + minutes + "分" + seconds + "秒";
    }

    /**
     * 日期格式化
     *
     * @param time 时间
     * @return 年-月-日字符串
     */
    public static String timeFormatDate(LocalDateTime time) {
        return DATE_FORMATTER.format(time);

    }

    /**
     * 日期格式化
     *
     * @param date 日期
     * @return 年-月-日字符串
     */
    public static String timeFormat(LocalDate date) {
        return DATE_FORMATTER.format(date);

    }

    /**
     * 时间格式化
     *
     * @param time 时间
     * @return 年-月-日 时:分:秒字符串
     */
    public static String timeFormat(LocalDateTime time) {
        return TIME_FORMATTER.format(time);

    }

    /**
     * 时间格式化
     *
     * @param date 日期
     * @return 年-月-日 时:分:秒字符串
     */
    public static String timeFormatDate(LocalDate date) {
        return TIME_FORMATTER.format(date);

    }

    /**
     * 获取当前时间的日期格式化后的字符串
     *
     * @return 日期格式化后的字符串
     */
    public static String currentDate() {
        return timeFormatDate(LocalDate.now());
    }

    /**
     * 获取当前时间的格式化后的字符串
     *
     * @return 时间的格式化后的字符串
     */
    public static String currentTime() {
        return timeFormat(LocalDateTime.now());
    }

    /**
     * 当天的0时0分0秒
     *
     * @return
     */

    public static long currentDateZeroTime() {
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDate = LocalDateTime.of(nowDate, nowTime);
        return localDate.toEpochSecond(ZoneOffset.ofHours(CHINA_TIME_ZONE));

    }

}
