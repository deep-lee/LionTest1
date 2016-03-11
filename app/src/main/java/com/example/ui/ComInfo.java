package com.example.ui;

import android.os.Bundle;
import android.widget.ListView;

import com.example.com.example.base.BaseActivity;
import com.example.sean.liontest1.R;

/**
 * Created by Administrator on 2016/3/7.
 */
public class ComInfo extends BaseActivity {

    //公司信息填写列表
    ListView ComInfo_listview;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_cominfo);
        ComInfo_listview = (ListView) findViewById(R.id.cominfo_listview);

    }
}
