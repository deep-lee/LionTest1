package com.example.sean.liontest1;

import android.app.Application;

/**
 * Created by Administrator on 2016/3/3.
 */

public class CustomApplcation extends Application {
    public static CustomApplcation mInstance;

    public CustomApplcation() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mInstance = this;
    }

    // 单例模式，才能及时返回数据
    public static CustomApplcation getInstance() {
        return mInstance;
    }
}
