package com.pashley.api.service;

import android.content.Context;

import com.pashley.api.BaseApi;
import com.pashley.api.listener.ResponseListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pashley on 2016/10/7.
 */

public class UserApi extends BaseApi{
    public UserApi(Context context) {
        super(context);
    }

    /**
     * 登陆
     * @param account
     * @param password
     * @param listener
     */
    public void loginByApp(String account, String password,ResponseListener listener){
        Map<String, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("password", password);
        request.post(USER_LOGIN, params, listener);
    }
    public void getHomeData(ResponseListener listener){
        Map<String, Object> params = new HashMap<>();
        request.get(HOME_DATA, params, listener);
    }
    public void getGoodsDetail(int id,ResponseListener listener){
        Map<String, Object> params = new HashMap<>();
        params.put("id",id);
        request.post(GOODS_DETAIL, params, listener);
    }

    /**
     *商品列表
     * @param attrFeature 特性
     * @param attrType 类型
     * @param carPart 部位
     * @param categoryId 分类
     * @param filmBrandId 品牌
     * @param listener
     */
    public void getGoodsList(int attrFeature,int attrType,int carPart,int categoryId,int filmBrandId,ResponseListener listener){
        Map<String, Object> params = new HashMap<>();
        params.put("attrFeature",attrFeature);
        params.put("attrType",attrType);
        params.put("carPart",carPart);
        params.put("categoryId",categoryId);
        params.put("filmBrandId",filmBrandId);
        request.post(GOODS_LIST, params, listener);
    }
}
