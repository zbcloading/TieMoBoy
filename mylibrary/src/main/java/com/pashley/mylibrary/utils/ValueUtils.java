package com.pashley.mylibrary.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Object转换到各种类型值的工具类
 * 
 * @author penghy
 * @date 2014-09-04
 */
public class ValueUtils {

	/**
	 * Object转换成boolean类型
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean toBoolean(Object obj) {
		if (obj == null) {
			return false;
		}
		try {
			return Boolean.parseBoolean(obj.toString());
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Object转换成byte类型
	 * 
	 * @param obj
	 * @return
	 */
	public static byte toByte(Object obj) {
		if (obj == null) {
			return 0;
		}
		try {
			return Byte.parseByte(obj.toString());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Object转换成int类型
	 * 
	 * @param obj
	 * @return
	 */
	public static int toInt(Object obj) {
		if (obj == null) {
			return 0;
		}
		try {
			return Integer.parseInt(obj.toString());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Object转换成double类型
	 * 
	 * @param obj
	 * @return
	 */
	public static double toDouble(Object obj) {
		if (obj == null) {
			return 0;
		}
		try {
			return Double.parseDouble(obj.toString());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Object转换成String类型
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		return obj != null ? obj.toString() : null;
	}

	/**
	 * Object转换成Date类型
	 * 
	 * @param obj
	 * @return
	 */
	public static Date toDate(Object obj) {
		return obj != null && obj instanceof Date ? (Date) obj : null;
	}

	/**
	 * Object转换成BigDecimal类型
	 * 
	 * @param obj
	 * @return
	 */
	public static BigDecimal toBigDecimal(Object obj) {
		try {
			return NumberUtils.createBigDecimal(toString(obj));
		} catch (Exception e) {
			return NumberUtils.createBigDecimal("0");
		}

	}

	/**
	 * 格式化价格数据，小数点后保留2位
	 * 
	 * @param price
	 * @return
	 */
	public static String formatPrice(BigDecimal price) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(price);
	}

	/**
	 * 格式化价格数据，小数点后保留2位
	 * 
	 * @param price
	 * @return
	 */
	public static String formatPrice(double price) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(price);
	}

	public static void main(String[] args) {
		System.out.println(formatPrice(new BigDecimal("33.568")));
	}
}
