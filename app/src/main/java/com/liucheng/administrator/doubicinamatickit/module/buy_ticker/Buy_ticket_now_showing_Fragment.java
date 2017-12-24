package com.liucheng.administrator.doubicinamatickit.module.buy_ticker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHitData;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.adapter.NowShowAdapter;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.DetailsActivity;

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
    ListView listViewHot;
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
        listViewHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("cinameId",hitList.get(i).getId()+"");
                startActivity(intent);
//                Toast.makeText(getContext(), "sdagvfdsgvbf", Toast.LENGTH_SHORT).show();
            }
        });
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
                    adapter = new NowShowAdapter(getActivity(),hitList);
                    listViewHot.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
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
