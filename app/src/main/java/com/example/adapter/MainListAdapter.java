package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.com.example.base.BaseListAdapter;
import com.example.sean.liontest1.R;
import java.util.List;

/**
 * Created by Administrator on 2016/3/7.
 *
 */
public class MainListAdapter extends BaseListAdapter {

    private Button btn_r1;
    private Button btn_r2;
    private Button btn_r3;
    private Button btn_r4;


    public MainListAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.main_list_item,null);

        //图片里面的简介
        TextView tv_title = MyViewHolder.get(convertView,R.id.main_item_title);
        tv_title.setText(list.get(position).toString());

        btn_r1 = MyViewHolder.get(convertView, R.id.b1_btn);
        btn_r2 = MyViewHolder.get(convertView,R.id.b2_btn);
        btn_r3 = MyViewHolder.get(convertView,R.id.b3_btn);
        btn_r4 = MyViewHolder.get(convertView,R.id.b4_btn);

        // TextView tv1 = convertView.findViewById(R.id.t)

        btn_r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这个文件直接用文本会有乱码，引用string才没有乱码
                Toast.makeText(mContext, R.string.huo_dong_shi_jian,Toast.LENGTH_SHORT).show();
                // ShowToast("活动时间");
            }
        });
        btn_r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowToast("活动发起人");
            }
        });
        btn_r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
