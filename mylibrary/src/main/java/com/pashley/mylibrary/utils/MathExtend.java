package com.pashley.mylibrary.utils;

/**
 * 
 * @author Jeff
 * @date 2014-8-19
 * @version 1.0
 */
public class MathExtend {
	/**
	 * 价格格式化，如果有小数点，并且小数点后的数字大于0则不格式化，否则删除小数点后的数字
	 * 
	 * @param price
	 * @return
	 */
//	public static String formatPrice(String price) {
//		if (price.indexOf(".") == -1) {
//			return price;
//		} else {
//			String[] p = price.split("\\.");
//			double _p = Double.parseDouble(p[1]);
//			if (_p > 0) {
//				return price;
//			} else {
//				return p[0];
//			}
//		}
//	}
//
//	public static String formatPrice(double price) {
//		String _price = String.valueOf(price);
//		if (_price.indexOf(".") == -1) {
//			return _price;
//		} else {
//			String[] p = _price.split("\\.");
//			double _p = Double.parseDouble(p[1]);
//			if (_p > 0) {
//				return _price;
//			} else {
//				return p[0];
//			}
//		}
//	}
	/**
	 * 四舍五入
	 * @param value
	 * @return
	 */
	public static String formatPrice(Object value) {
		if(value==null)
			return "";
		
		double price=Double.parseDouble(value.toString());
		int t = (int) Math.rint(price * 100);
		double d = (t / 100.0);

		return String.valueOf(d);
	}
}
