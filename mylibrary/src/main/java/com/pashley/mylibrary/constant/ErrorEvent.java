package com.pashley.mylibrary.constant;

/**
 * Created by Pashley on 2016/10/7.
 */

public class ErrorEvent {
    public static final int ERROR_MESSAGE = 400;    // 错误提示信息
    public static final int PARAM_NULL = 401;       // 参数为空
    public static final int ERROR_FAILURE = 403;    // 获取数据失败
    public static final int SERVER_ERROR=500;               //请求超时或者服务器端错误
    public static final int SERVER_DATA_EXCEPTION = 501;    //服务器结果转换错误
}
