package com.liucheng.administrator.doubicinamatickit.module.buy_ticker;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.MyFragmentAdapter;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.manager.LocationId;
import com.liucheng.administrator.doubicinamatickit.module.find.NewsFragment;
import com.liucheng.administrator.doubicinamatickit.module.find.RankingFragment;
import com.liucheng.administrator.doubicinamatickit.view.ImageText;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class BuyTicketFragment extends BaseFragment implements ImageText.OnImageWithTextViewClickListener {
    /**
     * 定位城市
     */
    private String city;
    //actionbar
    //声明控件
    RadioGroup radioGroup = null;
    ViewPager viewPager = null;
    Buy_ticket_upcoming_movies_Fragment upcoming_movies_fragment;
    Buy_ticket_now_showing_Fragment now_showing_fragment;
    MyFragmentAdapter adapter;

    Unbinder unbinder;
    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.buy_ticket_fragment, container, false);
        initialUI();
       // Listener();
        unbinder = ButterKnife.bind(this, contentView);
        EventBus.getDefault().register(this);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), FragmentPagerItems.with(getContext())
                .add("正在热映", Buy_ticket_now_showing_Fragment.class)
                .add("即将上映", Buy_ticket_upcoming_movies_Fragment.class)
                .create());
        viewpager.setAdapter(adapter);

        viewpagertab.setViewPager(viewpager);
        return contentView;
    }






    @Override
    public void initialUI() {


        //初始化控件

        actionBar = contentView.findViewById(R.id.include_actionbar_buy_ticket);
        initiaActionBar(R.drawable.ic_brake, city, "电影票", -1);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onViewClick(View view) {

    }



    @Subscribe
    public void onEvent(String data) {
        //如果是1 跳转到正在热映
        if (data.equals("0")){
            viewpager.setCurrentItem(0);

        } else   if (data.equals("1")){
            //如果是2 跳转到即将上映
            viewpager.setCurrentItem(1);
        }
        viewpagertab.setViewPager(viewpager);
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取当前城市
        city = MyApplication.getCityName();
        initialUI();
        //获取城市ID
        int Locationid = LocationId.getLocationId(getActivity(), R.raw.json);
        //Toast.makeText(getActivity(), "Locationid"+Locationid, Toast.LENGTH_SHORT).show();
    }
}
