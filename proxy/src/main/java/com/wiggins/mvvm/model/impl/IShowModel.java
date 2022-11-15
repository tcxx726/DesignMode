package com.wiggins.mvvm.model.impl;

import com.wiggins.mvvm.callback.OnCommonCallBack;
import com.wiggins.mvvm.callback.OnServerCallBack;
import com.wiggins.mvvm.http.HttpUtils;
import com.wiggins.mvvm.model.ShowModel;

import java.util.Map;

/**
 * @Description 显示操作接口实现
 * @Author 一花一世界
 */
public class IShowModel implements ShowModel {

    @Override
    public <T> void ShowStringData(String url, Map<String, String> params, OnCommonCallBack<T> callBack) {
        HttpUtils.getRequest(url, params, callBack);
    }

    @Override
    public <T, V> void ShowUser(String url, Map<String, String> params, OnServerCallBack<T, V> callBack) {
        HttpUtils.getRequest(url, params, callBack);
    }

    @Override
    public <T, V> void ShowListUser(String url, Map<String, String> params, OnServerCallBack<T, V> callBack) {
        HttpUtils.getRequest(url, params, callBack);
    }

    @Override
    public <T, V> void ShowUserInfo(String url, Map<String, String> params, OnServerCallBack<T, V> callBack) {
        HttpUtils.getRequest(url, params, callBack);
    }
}