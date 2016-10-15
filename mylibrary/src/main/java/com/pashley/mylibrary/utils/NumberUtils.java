package com.pashley.mylibrary.utils;

import java.math.BigDecimal;

/**
 * 数字类型操作工具类
 * @author penghy
 * @date 2014-05-21
 */
public class NumberUtils {

	private NumberUtils(){
		
	}
	/**
	 * <p>Convert a <code>String</code> to an <code>int</code>, returning
	 * <code>zero</code> if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, <code>zero</code> is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toInt(null) = 0
	 *   NumberUtils.toInt("")   = 0
	 *   NumberUtils.toInt("1")  = 1
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @return the int represented by the string, or <code>zero</code> if
	 *  conversion fails
	 * @since 2.1
	 */
	public static int toInt(String str) {
		return toInt(str, 0);
	}

	/**
	 * <p>Convert a <code>String</code> to an <code>int</code>, returning a
	 * default value if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, the default value is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toInt(null, 1) = 1
	 *   NumberUtils.toInt("", 1)   = 1
	 *   NumberUtils.toInt("1", 0)  = 1
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @param defaultValue  the default value
	 * @return the int represented by the string, or the default if conversion fails
	 * @since 2.1
	 */
	public static int toInt(String str, int defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(str.toString());
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>long</code>, returning
	 * <code>zero</code> if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, <code>zero</code> is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toLong(null) = 0L
	 *   NumberUtils.toLong("")   = 0L
	 *   NumberUtils.toLong("1")  = 1L
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @return the long represented by the string, or <code>0</code> if
	 *  conversion fails
	 * @since 2.1
	 */
	public static long toLong(String str) {
		return toLong(str, 0L);
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>long</code>, returning a
	 * default value if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, the default value is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toLong(null, 1L) = 1L
	 *   NumberUtils.toLong("", 1L)   = 1L
	 *   NumberUtils.toLong("1", 0L)  = 1L
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @param defaultValue  the default value
	 * @return the long represented by the string, or the default if conversion fails
	 * @since 2.1
	 */
	public static long toLong(String str, long defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>float</code>, returning
	 * <code>0.0f</code> if the conversion fails.</p>
	 *
	 * <p>If the string <code>str</code> is <code>null</code>,
	 * <code>0.0f</code> is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toFloat(null)   = 0.0f
	 *   NumberUtils.toFloat("")     = 0.0f
	 *   NumberUtils.toFloat("1.5")  = 1.5f
	 * </pre>
	 *
	 * @param str the string to convert, may be <code>null</code>
	 * @return the float represented by the string, or <code>0.0f</code>
	 *  if conversion fails
	 * @since 2.1
	 */
	public static float toFloat(String str) {
		return toFloat(str, 0.0f);
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>float</code>, returning a
	 * default value if the conversion fails.</p>
	 *
	 * <p>If the string <code>str</code> is <code>null</code>, the default
	 * value is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toFloat(null, 1.1f)   = 1.0f
	 *   NumberUtils.toFloat("", 1.1f)     = 1.1f
	 *   NumberUtils.toFloat("1.5", 0.0f)  = 1.5f
	 * </pre>
	 *
	 * @param str the string to convert, may be <code>null</code>
	 * @param defaultValue the default value
	 * @return the float represented by the string, or defaultValue
	 *  if conversion fails
	 * @since 2.1
	 */
	public static float toFloat(String str, float defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>double</code>, returning
	 * <code>0.0d</code> if the conversion fails.</p>
	 *
	 * <p>If the string <code>str</code> is <code>null</code>,
	 * <code>0.0d</code> is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toDouble(null)   = 0.0d
	 *   NumberUtils.toDouble("")     = 0.0d
	 *   NumberUtils.toDouble("1.5")  = 1.5d
	 * </pre>
	 *
	 * @param str the string to convert, may be <code>null</code>
	 * @return the double represented by the string, or <code>0.0d</code>
	 *  if conversion fails
	 * @since 2.1
	 */
	public static double toDouble(String str) {
		return toDouble(str, 0.0d);
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>double</code>, returning a
	 * default value if the conversion fails.</p>
	 *
	 * <p>If the string <code>str</code> is <code>null</code>, the default
	 * value is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toDouble(null, 1.1d)   = 1.1d
	 *   NumberUtils.toDouble("", 1.1d)     = 1.1d
	 *   NumberUtils.toDouble("1.5", 0.0d)  = 1.5d
	 * </pre>
	 *
	 * @param str the string to convert, may be <code>null</code>
	 * @param defaultValue the default value
	 * @return the double represented by the string, or defaultValue
	 *  if conversion fails
	 * @since 2.1
	 */
	public static double toDouble(String str, double defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	//-----------------------------------------------------------------------
	/**
	* <p>Convert a <code>String</code> to a <code>byte</code>, returning
	* <code>zero</code> if the conversion fails.</p>
	*
	* <p>If the string is <code>null</code>, <code>zero</code> is returned.</p>
	*
	* <pre>
	*   NumberUtils.toByte(null) = 0
	*   NumberUtils.toByte("")   = 0
	*   NumberUtils.toByte("1")  = 1
	* </pre>
	*
	* @param str  the string to convert, may be null
	* @return the byte represented by the string, or <code>zero</code> if
	*  conversion fails
	* @since 2.5
	*/
	public static byte toByte(String str) {
		return toByte(str, (byte) 0);
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>byte</code>, returning a
	 * default value if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, the default value is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toByte(null, 1) = 1
	 *   NumberUtils.toByte("", 1)   = 1
	 *   NumberUtils.toByte("1", 0)  = 1
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @param defaultValue  the default value
	 * @return the byte represented by the string, or the default if conversion fails
	 * @since 2.5
	 */
	public static byte toByte(String str, byte defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Byte.parseByte(str);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	/**
	 * <p>Convert a <code>String</code> to a <code>short</code>, returning
	 * <code>zero</code> if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, <code>zero</code> is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toShort(null) = 0
	 *   NumberUtils.toShort("")   = 0
	 *   NumberUtils.toShort("1")  = 1
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @return the short represented by the string, or <code>zero</code> if
	 *  conversion fails
	 * @since 2.5
	 */
	public static short toShort(String str) {
		return toShort(str, (short) 0);
	}

	/**
	 * <p>Convert a <code>String</code> to an <code>short</code>, returning a
	 * default value if the conversion fails.</p>
	 *
	 * <p>If the string is <code>null</code>, the default value is returned.</p>
	 *
	 * <pre>
	 *   NumberUtils.toShort(null, 1) = 1
	 *   NumberUtils.toShort("", 1)   = 1
	 *   NumberUtils.toShort("1", 0)  = 1
	 * </pre>
	 *
	 * @param str  the string to convert, may be null
	 * @param defaultValue  the default value
	 * @return the short represented by the string, or the default if conversion fails
	 * @since 2.5
	 */
	public static short toShort(String str, short defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Short.parseShort(str);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
	
	 /**
     * <p>Checks whether the String a valid Java number.</p>
     *
     * <p>Valid numbers include hexadecimal marked with the <code>0x</code>
     * qualifier, scientific notation and numbers marked with a type
     * qualifier (e.g. 123L).</p>
     *
     * <p><code>Null</code> and empty String will return
     * <code>false</code>.</p>
     *
     * @param str  the <code>String</code> to check
     * @return <code>true</code> if the string is a correctly formatted number
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // deal with any possible sign up front
        int start = (chars[0] == '-') ? 1 : 0;
        if (sz > start + 1) {
            if (chars[start] == '0' && chars[start + 1] == 'x') {
                int i = start + 2;
                if (i == sz) {
                    return false; // str == "0x"
                }
                // checking hex (it can't be anything else)
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9')
                        && (chars[i] < 'a' || chars[i] > 'f')
                        && (chars[i] < 'A' || chars[i] > 'F')) {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--; // don't want to loop to the last char, check it afterwords
              // for type qualifiers
        int i = start;
        // loop to the next to last char or to the last char if we need another digit to
        // make a valid number (e.g. chars[0..5] = "1234E")
        while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;

            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent   
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // we've already taken care of hex.
                if (hasExp) {
                    // two E's
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false; // we need a digit after the E
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // no type qualifier, OK
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                // can't have an E at the last byte
                return false;
            }
            if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                // single trailing decimal point after non-exponent is ok
                return foundDigit;
            }
            if (!allowSigns
                && (chars[i] == 'd'
                    || chars[i] == 'D'
                    || chars[i] == 'f'
                    || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l'
                || chars[i] == 'L') {
                // not allowing L with an exponent
                return foundDigit && !hasExp;
            }
            // last character is illegal
            return false;
        }
        // allowSigns is true iff the val ends in 'E'
        // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
        return !allowSigns && foundDigit;
    }

	/***************************BigDecimal相关操作***************************/

	//默认除法运算精度
	private static final int DEF_DIV_SCALE = 18;
	
	 /**
     * <p>Convert a <code>String</code> to a <code>BigDecimal</code>.</p>
     * 
     * <p>Returns <code>null</code> if the string is <code>null</code>.</p>
     *
     * @param str  a <code>String</code> to convert, may be null
     * @return converted <code>BigDecimal</code>
     * @throws NumberFormatException if the value cannot be converted
     */
    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        // handle JDK1.3.1 bug where "" throws IndexOutOfBoundsException
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }  
        return new BigDecimal(str);
    }

	/**
	 * 提供精确的加法运算。
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 小数点以后10位，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 定精度，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static void main(String args[]) {

		double d = NumberUtils.round(7.881876564025879, 1);
		System.out.println(d);
		
		System.out.println(NumberUtils.isNumber("10.25"));

	}
	
	

}
