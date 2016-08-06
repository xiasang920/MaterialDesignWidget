package com.mdw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mData;
    private String[] titles = new String[]{"TAB1","TAB2","TAB3"};
    public MyPagerAdapter(FragmentManager fm, List<Fragment> mData) {
        super(fm);
        this.mData = mData;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
