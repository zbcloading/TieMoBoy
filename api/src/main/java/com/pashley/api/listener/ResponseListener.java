package com.pashley.api.listener;

import com.pashley.model.RequestResult;

/**
 * Created by Pashley on 2016/10/7.
 */

public interface ResponseListener {

    /**
     * 失败时调用
     * @param errorEvent 错误码
     * @param e    错误信息
     */
    void onFailure(int errorEvent, Throwable e);
    /**
     * 成功时调用
     *
     * @param result 返回的数据
     */
    void onSuccess(RequestResult result);
}
