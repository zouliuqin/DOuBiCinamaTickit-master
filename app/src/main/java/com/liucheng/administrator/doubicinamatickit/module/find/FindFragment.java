package com.liucheng.administrator.doubicinamatickit.module.find;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class FindFragment extends BaseFragment {

    @BindView(R.id.rb_News)
    RadioButton rbNews;
    @BindView(R.id.rb_ranking)
    RadioButton rbRanking;
    Unbinder unbinder;
    @BindView(R.id.rl_find)
    RelativeLayout rlFind;
    //管理器
    private FragmentManager manager;
    //事务
    private FragmentTransaction transaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.find_fragment, container, false);

        unbinder = ButterKnife.bind(this, contentView);
        initialUI();

        initFragment();

        return contentView;
    }
    //初始化内部Fragment


    private void initFragment() {
        //初始化fragmentManager
        manager = getChildFragmentManager();
        //创建事务
        transaction = manager.beginTransaction();

        //添加fragment
        transaction.add(R.id.rl_find,new NewsFragment());


        //提交事务
        transaction.commit();
    }

    @Override
    public void initialUI() {
        //设置标题
        actionBar = contentView.findViewById(R.id.include_actionbar_find);
        initiaActionBar(-1, "", "发现", -1);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rb_News, R.id.rb_ranking})
    public void onViewClicked(View view) {
        //创建事务
        transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.rb_News:
                //资讯
                transaction.replace(R.id.rl_find, new NewsFragment());

                break;
            case R.id.rb_ranking:
                //票房榜
                transaction.replace(R.id.rl_find, new RankingFragment());
                break;
        }
        transaction.commit();
    }
}
