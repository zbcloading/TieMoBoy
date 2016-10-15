package com.pashley.core;

/**
 * Created by Pashley on 2016/10/7.
 */

public interface ActionCallbackListener<T> {
    /**
     * 成功时调用（只有请求成功状态为=0时）
     *
     * @param data 返回的数据
     */
    void onSuccess(T data);

    /**
     * 失败时调用（包括请求成功后状态返回!=0的状态）
     *
     * @param errorEvent 错误码
     * @param message    错误信息
     */
    void onFailure(int errorEvent, String message);

    /**
     * 上传错误日记
     * @param e
     */
    void onUpdateError(Throwable e);
}
