package com.liucheng.administrator.doubicinamatickit.module.buy_ticker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.adapter.UpcomingAdapter;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.UpcomingData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class Buy_ticket_upcoming_movies_Fragment extends BaseFragment implements UpcomingData.UpcomingLoadListener {
    List<Upcoming.MoviecomingsBean> upcomingList = new ArrayList<>();
    @BindView(R.id.upcoming_listView)
    ListView listView;
    Unbinder unbinder;
    UpcomingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.buy_ticket_upconming_movies_fragment, container, false);
        unbinder = ButterKnife.bind(this, contentView);
        UpcomingData.getIIsHitData(this);
        return contentView;
    }

    @Override
    public void initialUI() {


    }

    @Override
    public void onIsHitLoadEnd(Upcoming upcoming) {
        upcomingList.clear();
        upcomingList.addAll(upcoming.getMoviecomings());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new UpcomingAdapter(getActivity(),upcomingList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
