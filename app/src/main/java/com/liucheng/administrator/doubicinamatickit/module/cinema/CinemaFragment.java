package com.liucheng.administrator.doubicinamatickit.module.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.liucheng.administrator.doubicinamatickit.entity.Location;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.manager.LocationId;
import com.liucheng.administrator.doubicinamatickit.module.cinema.adapter.CinemaAdapter;
import com.liucheng.administrator.doubicinamatickit.module.cinema.data.CinemaData;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.CinemaPlaysMoviesActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class CinemaFragment extends BaseFragment implements CinemaData.CinemaLoadListener {
    List<Location.PBean> pBeans = new ArrayList<>();


    @BindView(R.id.rv_cinema)
    RecyclerView rvCinema;
    Unbinder unbinder;
    private CinemaAdapter cinemaAdapter;
    /**
     * 定位城市
     */
    private String city;
    /**
     * 默认城市ID为北京
     */
    int cityId;

    /**
     * 城市电影院
     */
    private List<Cinema.CinemaBean> cinemaBeans = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.cinema_fragment, container, false);
        unbinder = ButterKnife.bind(this, contentView);
        return contentView;


    }

    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_cinema);
        initiaActionBar(R.drawable.go, city, "影院", R.drawable.title_find);
        //TODO 设置即将上映
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCinema.setLayoutManager(manager);
        cinemaAdapter = new CinemaAdapter(R.layout.item_cinema, cinemaBeans);
        rvCinema.setAdapter(cinemaAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取当前城市
        city = MyApplication.getCityName();
        initialUI();
        //获取城市ID
        cityId = LocationId.getLocationId(getActivity(), R.raw.json);
        //获取城市影院
        CinemaData.getCinemaData(this, cityId);

        cinemaAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Cinema.CinemaBean   c =  cinemaBeans.get(position);
                //点击电影院 跳转到电影院详情
                Intent intent = new Intent(getActivity(), CinemaPlaysMoviesActivity.class);
                intent.putExtra("cinemaBeans", c);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCinemaLoadEnd(Cinema cinema) {
        //清除原有数据
        cinemaBeans.clear();
        //添加回调的数据到城市电影院中
        cinemaBeans.addAll(cinema.getCinema());
        //在UI线程显示 RecyclerView
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                cinemaAdapter.setNewData(cinemaBeans);
                cinemaAdapter.addHeaderView(getHeaderView());





            }
        });


    }

    private View getHeaderView() {
        View view = getLayoutInflater().inflate(R.layout.header_cinema, (ViewGroup) rvCinema.getParent(), false);
        TextView itemCinemaSign = view.findViewById(R.id.item_cinema_sign);
        TextView itemCinemaCinameName = view.findViewById(R.id.item_cinema_cinameName);
        TextView itemCinemaMinPrice = view.findViewById(R.id.item_cinema_minPrice);
        TextView itemCinemaAddress = view.findViewById(R.id.item_cinema_address);
        TextView itemCinemaDistance = view.findViewById(R.id.item_cinema_distance);
        ImageView itemCinemaVip = view.findViewById(R.id.item_cinema_vip);
        ImageView itemCinemaPark = view.findViewById(R.id.item_cinema_park);
        ImageView itemCinemaImax = view.findViewById(R.id.item_cinema_imax);
        ImageView itemCinemaWifi = view.findViewById(R.id.item_cinema_wifi);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
