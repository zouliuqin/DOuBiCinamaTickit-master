package com.liucheng.administrator.doubicinamatickit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class CinemaFragment extends BaseFragment {
    List<Location.PBean> pBeans = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.cinema_fragment, container, false);
        initialUI();



        return contentView;
    }

    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_cinema);
        initiaActionBar(R.drawable.go,"武汉","影院",R.drawable.title_find);
    }
}
