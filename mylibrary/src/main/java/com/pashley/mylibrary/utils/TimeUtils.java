package com.pashley.mylibrary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**  
 * describe:
 * @author Jeff
 * @version V1.0  2015年4月6日
 */
public class TimeUtils {
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE    = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_XLISTVIEW = new SimpleDateFormat("MM-dd HH:mm");
    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * 比较两个日期
     * @param DATE1
     * @param DATE2
     * @return 1.dt1 在dt2前 -1 dt1在dt2后
     */
    public static int compareDate(String DATE1, String DATE2) {
        try {
            Date dt1 = DEFAULT_DATE_FORMAT.parse(DATE1);
            Date dt2 = DEFAULT_DATE_FORMAT.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    /**
     * 比较两个日期
     * @param DATE1
     * @param DATE2
     * @return 1.dt1 在dt2前 -1 dt1在dt2后
     */
    public static int compareDateShort(String DATE1, String DATE2) {
        try {
            Date dt1 = DATE_FORMAT_DATE.parse(DATE1);
            Date dt2 = DATE_FORMAT_DATE.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    /**
     * 得到两个日期相差的天数
     *
     * @param date1
     *            <String>
     * @param date2
     *            <String>
     * @return int
     * @throws ParseException
     */
    public static int getDateSpace(String date1, String date2) {

        int days = -1;

        try {
            Calendar calst = Calendar.getInstance();
            Calendar caled = Calendar.getInstance();

            calst.setTime(parseDate("yyyy-MM-dd", date1));
            caled.setTime(parseDate("yyyy-MM-dd", date2));

            // 设置时间为0时
            calst.set(Calendar.HOUR_OF_DAY, 0);
            calst.set(Calendar.MINUTE, 0);
            calst.set(Calendar.SECOND, 0);
            caled.set(Calendar.HOUR_OF_DAY, 0);
            caled.set(Calendar.MINUTE, 0);
            caled.set(Calendar.SECOND, 0);
            // 得到两个日期相差的天数
            days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
            days = -1;
        }

        return days;
    }
    /**
     * 当前时间 2015-07-10
     * 参数：2015-07-09	return -1
     * 参数：2015-07-10	return 0
     * 参数：2015-07-11	return 1
     * @param date
     * @return
     * @author Jeff
     */
    public static int getDateSpace(String date) {
        int days = -1;
        try {
            Calendar calst = Calendar.getInstance();
            Calendar caled = Calendar.getInstance();

//			calst.setTime(parseDate("yyyy-MM-dd", date1));
            caled.setTime(parseDate("yyyy-MM-dd", date));

            // 设置时间为0时
            calst.set(Calendar.HOUR_OF_DAY, 0);
            calst.set(Calendar.MINUTE, 0);
            calst.set(Calendar.SECOND, 0);
            caled.set(Calendar.HOUR_OF_DAY, 0);
            caled.set(Calendar.MINUTE, 0);
            caled.set(Calendar.SECOND, 0);
            // 得到两个日期相差的天数
            days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
            days = -1;
        }

        return days;
    }
    /**
     * long time to string
     * 
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     * 
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     * 
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }
    
    public static String formatDateTime(long time) {
		if (0 == time) {
			return "";
		}
		return DATE_XLISTVIEW.format(new Date(time));
	}

    private static Date parseDate(String pattern, String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(date);
    }
}
