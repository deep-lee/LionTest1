package com.example.sean.liontest1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.example.adapter.MainListAdapter;
import com.example.com.example.base.BaseActivity;
import com.example.fragment.SlidingFragment;
import com.example.view.HeaderLayout;
import com.example.view.XListView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements XListView.IXListViewListener{

    private static SlidingMenu slidingMenu;
    private XListView mListView;
    RelativeLayout r_zhezhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTopBarForBoth("狮子会",
                R.mipmap.search_btn,
                new HeaderLayout.onRightImageButtonClickListener(){
            @Override
            public void onClick(View v) {

            }
        },
                R.mipmap.list,new HeaderLayout.onLeftImageButtonClickListener() {

            @Override
            public void onClick() {
                //左边list按钮
                slidingMenu.showMenu();} });

        r_zhezhao = (RelativeLayout) findViewById(R.id.r_zhezhao);
        r_zhezhao.setAlpha(0);
        //下拉刷新 上滑加载更多
        initXlistview();
        //侧滑
        initSlidingMenu();

    }

    public void initSlidingMenu(){

        slidingMenu = new SlidingMenu(MainActivity.this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //值越大，侧滑越窄
        slidingMenu.setBehindOffset(200);
        slidingMenu.setBehindScrollScale(1);
        slidingMenu.setShadowDrawable(R.drawable.xlistview_arrow);
        slidingMenu.setFadeDegree(1);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.slide_layout);

        // 设置专场动画效果
        slidingMenu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float scale = (float) (percentOpen * 0.25 + 0.75);
                canvas.scale(scale, scale, -canvas.getWidth()/2,
                        canvas.getHeight() /2);
                //主界面遮罩效果
                r_zhezhao.setAlpha(percentOpen<0.5?0:(float) (percentOpen *255));
            }
        });

//        slidingMenu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
//            @Override
//            public void onOpened() {
//                r_main.setBackgroundResource(R.mipmap.zhe_zhao);
//            }
//        });
//        slidingMenu.setOnClosedListener(new SlidingMenu.OnClosedListener() {
//            @Override
//            public void onClosed() {
//                r_main.setBackgroundResource(0);
//            }
//        });

/*        slidingMenu.setAboveCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float scale = (float) (1 - percentOpen * 0.25);
                canvas.scale(scale, scale, 0, canvas.getHeight() / 2);
            }
        });*/

        android.support.v4.app.Fragment slideFragment = new SlidingFragment(MainActivity.this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_slide, slideFragment).commit();

    }

    public void initXlistview(){

        mListView = (XListView) findViewById(R.id.main_xlistview);
        // 首先不允许加载更多
        mListView.setPullLoadEnable(false);
        // 允许下拉
        mListView.setPullRefreshEnable(true);
        // 设置监听器
        mListView.setXListViewListener(this);
        // mListView.pullRefreshing();
        mListView.setDividerHeight(0);

        List<String> list = new ArrayList<>();
        list.add("活动主题：狮子会发起“小稚气爱心助学”");
        list.add("活动主题：狮子会发起“山里学校，山里娃”");
        list.add("活动主题：狮子会发起“小稚气爱心助学”");
        list.add("活动主题：狮子会发起“山里学校，山里娃”");
        list.add("活动主题：狮子会发起“小稚气爱心助学”");
        list.add("活动主题：狮子会发起“山里学校，山里娃”");
        mListView.setAdapter
                (new MainListAdapter(MainActivity.this, list));
        /*mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/
    }


    private Handler handler = new Handler();

    @Override
    public void onRefresh() {
        // TODO Auto-generated method stub
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                ShowToast("刷新完成!");
                mListView.stopRefresh();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {

    }

    public static void showslide(){
        slidingMenu.showMenu();
    }
}
