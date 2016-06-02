package com.example.li.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager mViewPager;

    private String[] titles = {"新闻","热点事件","软件技术","视频娱乐","社会现象","体育健康"};
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private LayoutInflater mInflater;
    private View view1,view2,view3,view4,view5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = ((ViewPager) findViewById(R.id.vp_FindFragment_pager));
        tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[2]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[3]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[4]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[5]));

        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.view1, null);
        view2 = mInflater.inflate(R.layout.view2, null);
        view3 = mInflater.inflate(R.layout.view3, null);
        view4 = mInflater.inflate(R.layout.view4, null);
        view5 = mInflater.inflate(R.layout.view5, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);

        MyAdapter mAdapter = new MyAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        tabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器


    }

    class MyAdapter extends PagerAdapter{

        private List<View> mList;

        public MyAdapter(List<View> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];//页卡标题
        }
    }
}
