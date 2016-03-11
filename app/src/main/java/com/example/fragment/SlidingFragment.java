package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.SlidingAdater;
import com.example.sean.liontest1.R;
import com.example.ui.MySetting;
import com.example.ui.Profile;
import com.example.ui.SouSuoQiYe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 *
 */
public class SlidingFragment extends Fragment{

    private View mView;
    private Context context;
    private List<String> list;

    public SlidingFragment(){
        super();
    }
    public SlidingFragment(Context context) {
        super();
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (mView == null)
        {
            initView(inflater, container);
        }
        return mView;
    }

    protected void initView(LayoutInflater inflater, ViewGroup container){
        mView = inflater.inflate(R.layout.slide_main, container,false);
        list = new ArrayList<>();
        list.add("商家地图");
        list.add("添加活动");
        list.add("个人中心");
        list.add("搜索企业");
        list.add("设置");
        list.add("反馈");
        list.add("关于");

        ListView myListView = (ListView) mView.findViewById(R.id.slide_listview);
        myListView.setAdapter(new SlidingAdater(context,list));
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Class<?> cls = null;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://商家地图
                        cls = null;
                        break;
                    case 1://添加活动
                        cls = null;
                        break;
                    case 2://个人中心
                            cls= Profile.class;
                        break;
                    case 3://搜索企业
                        cls = SouSuoQiYe.class;
                        break;
                    case 4://设置
                        cls = MySetting.class;
                        break;
                    case 5://反馈
                        cls = null;
                        break;
                    case 6://关于
                        cls = null;
                        break;
                }
                Intent intent = new Intent(context,cls);
                startActivity(intent);
                Toast.makeText(context,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        ImageView icon = (ImageView) mView.findViewById(R.id.slide_icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        TextView name_tv = (TextView) mView.findViewById(R.id.slide_name);
        name_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
