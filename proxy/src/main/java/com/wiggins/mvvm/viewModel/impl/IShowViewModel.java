package com.wiggins.mvvm.viewModel.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.ObservableField;

import com.wiggins.mvvm.R;
import com.wiggins.mvvm.bean.User;
import com.wiggins.mvvm.bean.UserInfo;
import com.wiggins.mvvm.callback.HttpResult;
import com.wiggins.mvvm.callback.OnCommonCallBack;
import com.wiggins.mvvm.callback.OnServerCallBack;
import com.wiggins.mvvm.databinding.ActivityMainBinding;
import com.wiggins.mvvm.model.ShowModel;
import com.wiggins.mvvm.model.impl.IShowModel;
import com.wiggins.mvvm.utils.Constant;
import com.wiggins.mvvm.utils.LogUtil;
import com.wiggins.mvvm.view.UsersActivity;
import com.wiggins.mvvm.viewModel.ShowViewModel;

import java.util.List;

/**
 * @Description 显示接口实现
 * @Author 一花一世界
 */
public class IShowViewModel implements ShowViewModel {

    private ShowModel showModel;
    private Context mContext;
    public ObservableField<String> callBackData = new ObservableField<>();

    public IShowViewModel(Context context, ActivityMainBinding binding) {
        this.mContext = context;
        binding.setShowViewModel(this);
        showModel = new IShowModel();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_users:
                Intent intent = new Intent(mContext, UsersActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.btn_default_data:
                onShowUser();
                break;
            case R.id.btn_refresh_data:
                onShowUserInfo();
                break;
            case R.id.btn_load_data:
                onShowListUser();
                break;
        }
    }

    @Override
    public void onShowUser() {
        //解析Http返回的Json数据，返回data字段中封装的内容
        showModel.ShowUser(Constant.object1, null, new OnServerCallBack<HttpResult<User>, User>() {
            @Override
            public void onSuccess(User data) {
                LogUtil.e("ShowUser-->" + data.toString());
            }

            @Override
            public void onFailure(int code, String msg) {
                LogUtil.e("ShowUser failure-->" + code + " : " + msg);
            }
        });
        //不解析Http返回的Json数据，返回Http返回的内容
        showModel.ShowStringData(Constant.object1, null, new OnCommonCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                LogUtil.e("ShowStringData-->" + data);
                callBackData.set(data);
            }

            @Override
            public void onFailure(int code, String msg) {
                LogUtil.e("ShowStringData failure-->" + code + " : " + msg);
                callBackData.set("code-->" + code + "\nmsg-->" + msg);
            }
        });
    }

    @Override
    public void onShowListUser() {
        showModel.ShowListUser(Constant.arrayList, null, new OnServerCallBack<HttpResult<List<User>>, List<User>>() {
            @Override
            public void onSuccess(List<User> data) {
                LogUtil.e("ShowListUser-->" + data.toString());
            }

            @Override
            public void onFailure(int code, String msg) {
                LogUtil.e("ShowListUser failure-->" + code + " : " + msg);
            }
        });
        showModel.ShowStringData(Constant.arrayList, null, new OnCommonCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                LogUtil.e("ShowStringData-->" + data);
                callBackData.set(data);
            }

            @Override
            public void onFailure(int code, String msg) {
                LogUtil.e("ShowStringData failure-->" + code + " : " + msg);
                callBackData.set("code-->" + code + "\nmsg-->" + msg);
            }
        });
    }

    @Override
    public void onShowUserInfo() {
        showModel.ShowUserInfo(Constant.object2, null, new OnServerCallBack<HttpResult<UserInfo>, UserInfo>() {
            @Override
            public void onSuccess(UserInfo data) {
                LogUtil.e("ShowUserInfo-->" + data.toString());
            }

            @Override
            public void onFailure(int code, String msg) {
                LogUtil.e("ShowUserInfo failure-->" + code + " : " + msg);
            }
        });
        showModel.ShowStringData(Constant.object2, null, new OnCommonCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                LogUtil.e("ShowStringData-->" + data);
                callBackData.set(data);
            }

            @Override
            public void onFailure(int code, String msg) {
                LogUtil.e("ShowStringData failure-->" + code + " : " + msg);
                callBackData.set("code-->" + code + "\nmsg-->" + msg);
            }
        });
    }
}
