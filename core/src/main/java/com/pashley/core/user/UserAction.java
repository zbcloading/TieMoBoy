package com.pashley.core.user;

import com.pashley.api.listener.ResponseListener;
import com.pashley.core.ActionCallbackListener;
import com.pashley.model.Goods;
import com.pashley.model.RequestResult;
import com.pashley.model.UserInfo;

import java.util.List;

/**
 * Created by Pashley on 2016/10/7.
 */

public interface UserAction {
    void loginByApp(String account, String password,ActionCallbackListener<UserInfo> listener);
    void getHomeData(ResponseListener listener);
    void getGoodsDetail(int id,ResponseListener listener);
    void getGoodsList(int attrFeature,int attrType,int carPart,int categoryId,int filmBrandId,ActionCallbackListener<RequestResult> listener);
}
