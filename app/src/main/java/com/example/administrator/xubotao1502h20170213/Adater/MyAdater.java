package com.example.administrator.xubotao1502h20170213.Adater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.xubotao1502h20170213.MainActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public class MyAdater extends FragmentPagerAdapter{
    private final FragmentManager supportFragmentManager;
    private final MainActivity mainActivity;
    private final String[] titleArr;
    private final List<Fragment> fragmentList;

    public MyAdater(FragmentManager supportFragmentManager, MainActivity mainActivity, String[] titleArr, List<Fragment> fragmentList) {
        super(supportFragmentManager);
        this.supportFragmentManager = supportFragmentManager;
        this.mainActivity = mainActivity;
        this.titleArr = titleArr;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr[position];
    }
}
