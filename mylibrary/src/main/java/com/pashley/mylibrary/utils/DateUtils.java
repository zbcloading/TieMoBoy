package com.pashley.mylibrary.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具类
 * 
 * @author penghy
 * @date 2014-08-11
 */
@SuppressLint("SimpleDateFormat")
public class DateUtils {

	public static final long DAY = 24 * 60 * 60 * 1000;

	private static final DateFormat DATE_FROMAT = new SimpleDateFormat("yyyy-MM-dd");

	private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final DateFormat SIMPLE_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * 日期对象格式化为string
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return DATE_FROMAT.format(date);
	}

	/**
	 * 日期对象格式化为string
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * 带时间的日期对象格式化为string
	 * 
	 * @param datetime
	 * @return
	 */
	public static String formatDatetime(Date datetime) {
		return DATETIME_FORMAT.format(datetime);
	}

	/**
	 * 带时间的日期对象格式化为string
	 * 
	 * @param datetime
	 * @return
	 */
	public static String formatSimpleDatetime(Date datetime) {
		return SIMPLE_DATETIME_FORMAT.format(datetime);
	}

	/**
	 * 带时间的日期对象格式化为string
	 * 
	 * @param datetime
	 * @param format
	 * @return
	 */
	public static String formatDatetime(Date datetime, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(datetime);
	}

	/**
	 * string日期转换为日期对象
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date) {
		try {
			return DATE_FROMAT.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * string日期转换为日期对象
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parseDate(String date, String format) {
		try {
			DateFormat df = new SimpleDateFormat(format);
			return df.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 带时间的string日期转换为日期对象
	 * 
	 * @param datetime
	 * @return
	 */
	public static Date parseSimpleDatetime(String datetime) {
		try {
			return SIMPLE_DATETIME_FORMAT.parse(datetime);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 带时间的string日期转换为日期对象
	 * 
	 * @param datetime
	 * @return
	 */
	public static Date parseDatetime(String datetime) {
		try {
			return DATETIME_FORMAT.parse(datetime);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 带时间的string日期转换为日期对象
	 * 
	 * @param datetime
	 * @param format
	 * @return
	 */
	public static Date parseDatetime(String datetime, String format) {
		try {
			DateFormat df = new SimpleDateFormat(format);
			return df.parse(datetime);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取当期日期
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取时间，格式如yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDatetime() {
		String d = DateUtils.formatDatetime(new Date());
		String ymd = d.substring(0, 10);
		String hms = d.substring(11, d.length());
		ymd = ymd.replace("-", "");
		hms = hms.replace(":", "");
		return ymd + hms;
	}

	/**
	 * 获取当前日期增加几天后的日期
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDays(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, amount);
		return c.getTime();
	}
	
	/**
	 * 获取当前日期减去几天后的日期
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date subDays(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 0-amount);
		return c.getTime();
	}

	/**
	 * 获取当前时间增加几小时后的时间
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addHours(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, amount);
		return c.getTime();
	}

	/**
	 * 获取当前时间减去几小时后的时间
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date subHours(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		amount = 0 - amount;
		c.add(Calendar.HOUR_OF_DAY, amount);
		return c.getTime();
	}

	/**
	 * 两个日期之间相差的天数
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static long days(Date begin, Date end) {
		long between = end.getTime() - begin.getTime();// 得到两者的毫秒数
		return between / DAY;
	}

	/**
	 * 两个日期之间相差的秒数
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static long seconds(Date begin, Date end) {
		long between = end.getTime() - begin.getTime();// 得到两者的毫秒数
		return between / 1000;
	}

	/**
	 * 两个日期之间相差的时间描述信息
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String timeInfo(Date begin, Date end) {
		long between = end.getTime() - begin.getTime();// 得到两者的毫秒数
		long days = days(begin, end);

		long hour = (between / (60 * 60 * 1000) - days * 24);
		long min = ((between / (60 * 1000)) - days * 24 * 60 - hour * 60);

		long year = 0;
		long month = 0;
		long day = 0;
		if (days > 365) {
			year = days / 365;
		}
		days = days - year * 365;
		if (days > 30) {
			month = days / 30;
		}

		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.add(Calendar.MONTH, (int) month + (int) year * 12);
		day = days(c.getTime(), end);

		StringBuilder sb = new StringBuilder();
		if (year > 0) {
			sb.append(year + "年");
		}
		if (month > 0) {
			sb.append(month + "月");
		}
		if (day > 0) {
			sb.append(day + "天");
		}
		if (hour > 0) {
			sb.append(hour + "小时");
		}
		if (min > 0) {
			sb.append(min + "分");
		}
		return sb.toString();
	}

	/**
	 * 两个日期之间相差的时间描述信息
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static long[] getTimeInfos(Date begin, Date end) {
		long between = end.getTime() - begin.getTime();// 得到两者的毫秒数
		long days = days(begin, end);

		long hour = (between / (60 * 60 * 1000) - days * 24);
		long min = ((between / (60 * 1000)) - days * 24 * 60 - hour * 60);

		long year = 0;
		long month = 0;
		long day = 0;
		if (days > 365) {
			year = days / 365;
		}
		days = days - year * 365;
		if (days > 30) {
			month = days / 30;
		}

		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.add(Calendar.MONTH, (int) month + (int) year * 12);
		day = days(c.getTime(), end);

		long[] time = new long[5];
		time[0] = year;
		time[1] = month;
		time[2] = day;
		time[3] = hour;
		time[4] = min;
		return time;
	}

	/**
	 * 判断日期date是否在begin,end日期范围之内
	 * 
	 * @param now
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean dateRange(Date date, Date begin, Date end) {
		return date.getTime() >= begin.getTime() && date.getTime() <= end.getTime();
	}

	/**
	 * 判断当前时间是否在begin,end日期范围之内
	 * 
	 * @param now
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean dateRange(Date begin, Date end) {
		return dateRange(DateUtils.getCurrentDate(), begin, end);
	}

	/**
	 * 获取当前日期的最小和最大日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date[] getMinAndMaxDate(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date begin = c.getTime();

		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date end = c.getTime();

		return new Date[] { begin, end };

	}
}
