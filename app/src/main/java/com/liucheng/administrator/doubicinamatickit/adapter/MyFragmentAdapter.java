package com.liucheng.administrator.doubicinamatickit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
//保存需要适配的Fragment的集合
    List<Fragment> fragments =new ArrayList<Fragment>();
    //向集合中添加Fragment的方法
    public void addFragment(Fragment fragment){
        if (fragment != null){
            fragments.add(fragment);
            notifyDataSetChanged();
        }
    }



    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
