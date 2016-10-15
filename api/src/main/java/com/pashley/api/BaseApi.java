package com.pashley.api;

import android.content.Context;

import com.pashley.api.net.HttpRequest;
import com.pashley.model.AppInfo;

/**
 * Created by Pashley on 2016/10/7.
 */

public class BaseApi {
    protected static HttpRequest request;
    public BaseApi(Context context){
        if(request==null){
            request=HttpRequest.getInstance(context);
        }
    }

    public AppInfo getAppInfo(){
        if(request!=null){
            return request.getAppInfo();
        }
        return null;
    }
    /**
     * 用户名登录
     */
    protected final static String USER_LOGIN="user/login";

    /**
     * 获取首页数据
     */
    protected final static String HOME_DATA="home/data";
    /**
     * 商品详情
     */
    protected final static String GOODS_DETAIL="goods/detail";
    /**
     * 商品列表
     */
    protected final static String GOODS_LIST="goods/list";
}
