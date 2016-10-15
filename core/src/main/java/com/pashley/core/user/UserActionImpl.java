package com.pashley.core.user;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pashley.api.listener.ResponseListener;
import com.pashley.api.service.UserApi;
import com.pashley.core.ActionCallbackListener;
import com.pashley.core.R;
import com.pashley.model.Goods;
import com.pashley.model.RequestResult;
import com.pashley.model.UserInfo;
import com.pashley.mylibrary.constant.ErrorEvent;
import com.pashley.mylibrary.utils.StringUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Pashley on 2016/10/7.
 */

public class UserActionImpl implements UserAction {
    private UserApi userApi;
    private String message;
    private Context context;
//    private UserActionImpl userActionImpl;
    public UserActionImpl(Context context) {
        userApi = new UserApi(context);
        this.context = context;
    }
//    public UserActionImpl getInstance(Context context){
//        this.context = context;
//        if (userApi == null){
//            userApi = new UserApi(context);
//        }
//        if (userActionImpl== null){
//            userActionImpl = new UserActionImpl(context);
//        }
//        return  userActionImpl;
//    }
    @Override
    public void loginByApp(String account, String password, final ActionCallbackListener<UserInfo> listener) {
        if (StringUtils.isBlank(account)) {
            if (listener != null) {
                message = context.getResources().getString(R.string.edit_username_empty);
                listener.onFailure(ErrorEvent.PARAM_NULL, message);
            }
            return;
        }
        if (StringUtils.isBlank(password)) {
            if (listener != null) {
                message = context.getResources().getString(R.string.edit_password_empty);
                listener.onFailure(ErrorEvent.PARAM_NULL, message);
            }
            return;
        }
        userApi.loginByApp(account, password, new ResponseListener() {
            @Override
            public void onFailure(int errorEvent, Throwable e) {
                listener.onFailure(errorEvent, message);
            }

            @Override
            public void onSuccess(RequestResult result) {
                if (result.isSuccess()) {
                    Type typeOfT = new TypeToken<UserInfo>() {
                    }.getType();
                    Gson gson = new Gson();
                    UserInfo object = gson.fromJson(result.getResult().toString(), typeOfT);
                    listener.onSuccess(object);
                } else {
                    listener.onFailure(result.getCode(), result.getMsg());
                }
            }
        });
    }

    @Override
    public void getHomeData(final ResponseListener listener) {
        userApi.getHomeData(new ResponseListener() {
            @Override
            public void onFailure(int errorEvent, Throwable e) {
                listener.onFailure(errorEvent,e);
            }

            @Override
            public void onSuccess(RequestResult result) {
                listener.onSuccess(result);
            }
        });
    }

    @Override
    public void getGoodsDetail(int id, final ResponseListener listener) {
        userApi.getGoodsDetail(id, new ResponseListener() {
            @Override
            public void onFailure(int errorEvent, Throwable e) {
                listener.onFailure(errorEvent,e);
            }

            @Override
            public void onSuccess(RequestResult result) {
                listener.onSuccess(result);
            }
        });
    }

    @Override
    public void getGoodsList(int attrFeature, int attrType, int carPart, int categoryId, int filmBrandId, ActionCallbackListener<RequestResult> listener) {
        userApi.getGoodsList(attrFeature, attrType, carPart, categoryId, filmBrandId, new ResponseListener() {
            @Override
            public void onFailure(int errorEvent, Throwable e) {

            }

            @Override
            public void onSuccess(RequestResult result) {

            }
        });
    }
}
