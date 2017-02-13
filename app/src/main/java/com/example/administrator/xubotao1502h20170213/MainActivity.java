package com.example.administrator.xubotao1502h20170213;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.xubotao1502h20170213.Adater.MyAdater;
import com.example.administrator.xubotao1502h20170213.Fragment.Massage_Fragment;
import com.example.administrator.xubotao1502h20170213.Uilt.HttpUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] titleArr=new String[]{"社会","国内","娱乐","体育","军事","科技","财经","时尚","头条"};
    private List<Fragment> fragmentList=new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到控件
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addFragment();
        MyAdater myAdater = new MyAdater(getSupportFragmentManager(), this, titleArr, fragmentList);
        //设置添加适配器
        viewPager.setAdapter(myAdater);
        //给tablayout添加布局
        tabLayout.setupWithViewPager(viewPager);
        //设置样式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public void addFragment() {
        for (int i=0;i<titleArr.length;i++)
        {
            Massage_Fragment massage_fragment = new Massage_Fragment();
            fragmentList.add(massage_fragment);
        }
    }
}
