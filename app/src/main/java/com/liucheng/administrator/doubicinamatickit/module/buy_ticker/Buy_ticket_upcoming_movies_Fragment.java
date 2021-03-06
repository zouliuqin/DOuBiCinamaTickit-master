package com.liucheng.administrator.doubicinamatickit.module.buy_ticker;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.adapter.UpcomingAdapter;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.UpcomingData;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.DetailsActivity;

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
    RecyclerView listView;
    Unbinder unbinder;
    UpcomingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.buy_ticket_upconming_movies_fragment, container, false);
        unbinder = ButterKnife.bind(this, contentView);
        UpcomingData.getUpcomingData(this);
        Listener();
        return contentView;
    }

    private void Listener() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(manager);
        adapter = new UpcomingAdapter(R.layout.upcoming_show,upcomingList);
        listView.setAdapter(adapter);


        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("cinameId",upcomingList.get(position).getId()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void initialUI() {


    }

    @Override
    public void onUpcomingLoadEnd(Upcoming upcoming) {
        upcomingList.clear();
        upcomingList.addAll(upcoming.getMoviecomings());

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setNewData(upcomingList);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
