package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.com.example.base.BaseActivity;
import com.example.sean.liontest1.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Administrator on 2016/3/4.
 * 登录界面
 */
public class LogUI extends BaseActivity {

    EditText username_et, psw_et;
    Button login_btn, forget_btn, reg_btn;
    AVLoadingIndicatorView avLoadingIndicatorView;
    Animation scale_animation;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        // 设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log);
        initview();
    }

    protected void initview(){
        username_et = (EditText) findViewById(R.id.uname_edt);
        psw_et = (EditText) findViewById(R.id.pawd_edt);
        login_btn = (Button) findViewById(R.id.log_btn);
        forget_btn = (Button) findViewById(R.id.forget_btn);
        reg_btn = (Button) findViewById(R.id.reg_btn);
        avLoadingIndicatorView = (AVLoadingIndicatorView)findViewById(R.id.avloadingIndicatorView);
        //用户名 密码
        String uname,pawd=null;

        scale_animation = AnimationUtils.loadAnimation(LogUI.this, R.anim.login_btn_scale_animation);

        //注册监听器
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 首先检查是否为空
                if (username_et.getText().toString().isEmpty() || psw_et.getText().toString().isEmpty()) {
                    ShowToast("用户名或密码不能为空");
                    return;
                }

                login();
            }
        });
        forget_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进入注册界面
                Intent regIntent = new Intent(LogUI.this, RegUI.class);
                LogUI.this.startActivity(regIntent);
            }
        });

    }

    protected void login() {
        // login_btn.setVisibility(View.INVISIBLE);
        login_btn.startAnimation(scale_animation);
        avLoadingIndicatorView.setVisibility(View.VISIBLE);
        String  tag_login_req = "login_req";

    }
}
