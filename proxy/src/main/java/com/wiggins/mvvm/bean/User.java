package com.wiggins.mvvm.bean;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.squareup.picasso.Picasso;

/**
 * @Description 用户
 * @Author 一花一世界
 */
public class User extends BaseObservable {

    private ObservableField<String> userName = new ObservableField<>();
    private ObservableField<String> nickName = new ObservableField<>();
    private ObservableField<String> userAvatar = new ObservableField<>();

    public User(String userName, String nickName, String userAvatar) {
        this.userName.set(userName);
        this.nickName.set(nickName);
        this.userAvatar.set(userAvatar);
    }

    @BindingAdapter("bind:userAvatar")
    public static void getAvatarImage(ImageView iv, String userAvatar) {
        Picasso.with(iv.getContext())
                .load(userAvatar)
                .into(iv);
    }

    public void onItemClick(View view) {
        Toast.makeText(view.getContext(), getNickName(), Toast.LENGTH_SHORT).show();
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getNickName() {
        return nickName.get();
    }

    public void setNickName(String nickName) {
        this.nickName.set(nickName);
    }

    public String getUserAvatar() {
        return userAvatar.get();
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar.set(userAvatar);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                '}';
    }
}