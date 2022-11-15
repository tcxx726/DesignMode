package com.wiggins.mvvm.model;

import com.wiggins.mvvm.callback.OnCommonCallBack;
import com.wiggins.mvvm.callback.OnServerCallBack;

import java.util.Map;

/**
 * @Description 显示操作接口
 * @Author 一花一世界
 */
public interface ShowModel {

    <T> void ShowStringData(String url, Map<String, String> params, OnCommonCallBack<T> callBack);

    <T, V> void ShowUser(String url, Map<String, String> params, OnServerCallBack<T, V> callBack);

    <T, V> void ShowListUser(String url, Map<String, String> params, OnServerCallBack<T, V> callBack);

    <T, V> void ShowUserInfo(String url, Map<String, String> params, OnServerCallBack<T, V> callBack);
}
