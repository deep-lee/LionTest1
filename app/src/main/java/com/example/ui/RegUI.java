package com.example.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.com.example.base.BaseActivity;
import com.example.sean.liontest1.R;

/**
 * Created by Administrator on 2016/3/11.
 *
 */
public class RegUI extends BaseActivity{

    private Button reg_sure;
    private EditText usr_name;
    private EditText password1;
    private EditText password2;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_reg_ui);
        initview();
    }

    private void initview() {
        initTopBarForLeft("注册");
        reg_sure = (Button) findViewById(R.id.reg_sure);
        usr_name = (EditText) findViewById(R.id.user_name_edt);
        password1 = (EditText) findViewById(R.id.password_edt1);
        password2 = (EditText) findViewById(R.id.password_edt2);

    }

}
