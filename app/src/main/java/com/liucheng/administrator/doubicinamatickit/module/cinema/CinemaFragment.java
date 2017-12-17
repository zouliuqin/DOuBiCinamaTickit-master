package com.liucheng.administrator.doubicinamatickit.module.cinema;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.liucheng.administrator.doubicinamatickit.entity.Location;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.manager.LocationId;
import com.liucheng.administrator.doubicinamatickit.module.cinema.data.CinemaData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class CinemaFragment extends BaseFragment implements CinemaData.CinemaLoadListener{
    List<Location.PBean> pBeans = new ArrayList<>();




    /**
     * 定位城市
     */
    private  String city;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.cinema_fragment, container, false);



        return contentView;


    }

    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_cinema);
        initiaActionBar(R.drawable.go,city,"影院",R.drawable.title_find);
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取当前城市
        city= MyApplication.getCityName();
        initialUI();
        //获取城市ID
//        int cityId = LocationId.getLocationId(getActivity(), R.raw.json);
        //获取城市影院
        CinemaData.getNewsData(this,292);

    }

    @Override
    public void onCinemaLoadEnd(Cinema cinema) {
        Log.i("TAG", "onCinemaLoadEnd: "+cinema.getCinema().toString());

    }
}
