package com.wiggins.mvvm.app;

import android.app.Application;
import android.content.Context;

/**
 * @author Admin
 */
public class MyApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
