package com.liucheng.administrator.doubicinamatickit.module.buy_ticker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHitData;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.adapter.NowShowAdapter;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.DetailsActivity;
import com.liucheng.administrator.doubicinamatickit.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class Buy_ticket_now_showing_Fragment extends BaseFragment implements IsHitData.IsHitLoadListener {
    List<IsHit.MsBean> hitList = new ArrayList<>();
    @BindView(R.id.listView_Hot)
    RecyclerView listViewHot;
    Unbinder unbinder;
    NowShowAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.buy_ticket_now_showing_fragment, container, false);
        unbinder = ButterKnife.bind(this, contentView);


        return contentView;
    }

    private void Listener() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        listViewHot.setLayoutManager(manager);
        adapter = new NowShowAdapter(R.layout.now_hot_show,hitList);
        listViewHot.setAdapter(adapter);



        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("cinameId",hitList.get(position).getId()+"");
                startActivity(intent);
            }
        });
//        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                ((MainActivity)getActivity()).getViewPager_main().setCurrentItem(2);
//            }
//        });


//        listViewHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
////                Toast.makeText(getContext(), "sdagvfdsgvbf", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void initialUI() {

    }

    @Override
    public void onResume() {
        super.onResume();
        IsHitData.getIIsHitData(this);
        Listener();
    }

    @Override
    public void onIsHitLoadEnd(IsHit isHit) {
        hitList.clear();
        hitList.addAll(isHit.getMs());
        if (hitList!=null){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                   adapter.setNewData(hitList);

                }
            });


        }





    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
