package com.example.ui;

import android.os.Bundle;

import com.example.com.example.base.BaseActivity;
import com.example.sean.liontest1.MainActivity;
import com.example.sean.liontest1.R;
import com.example.view.HeaderLayout;

/**
 * Created by Administrator on 2016/3/9.
 *  个人资料界面
 */
public class Profile extends BaseActivity{

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_profile);
        initTopBarForLeft("个人中心");
    }
}
