package com.liucheng.administrator.doubicinamatickit.module.find;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.BoxOffice;
import com.liucheng.administrator.doubicinamatickit.entity.MovieBoxOffice;
import com.liucheng.administrator.doubicinamatickit.module.find.adapter.RankingAdapter;
import com.liucheng.administrator.doubicinamatickit.module.find.data.BoxOfficeData;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;
import com.liucheng.administrator.doubicinamatickit.sql.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class RankingFragment extends Fragment implements BoxOfficeData.BoxOfficeLoadListener {


    @BindView(R.id.lv_ranking)
    ListView lvRanking;
    Unbinder unbinder;
    @BindView(R.id.srl_ranking)
    SwipeRefreshLayout srlRanking;

    //票房数据
    private List<BoxOffice.MoviesBean> boxOffices = new ArrayList<>();
    private RankingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        unbinder = ButterKnife.bind(this, view);


        initUi();
        //获取排行榜数据
        BoxOfficeData.getNewsData(this);

        return view;


    }

    private void initUi() {
        //添加头
        View headerView = View.inflate(getActivity(), R.layout.header_ranking, null);
        lvRanking.addHeaderView(headerView);
        //设置下拉刷新

        //默认下拉刷新ui颜色
        srlRanking.setColorSchemeColors(Color.parseColor("#000000"));
        srlRanking.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //加载票房数据
                        BoxOfficeData.getNewsData(RankingFragment.this);
                        //swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
                //停止更新
                srlRanking.setRefreshing(false);
            }
        });


        lvRanking.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               //获取点击的电影名称
//
//              String[]  movieName={boxOffices.get(i-1).getMovieName()};
//               String[]  movieId={"movieId"};
//          //    String dataSelection = ContactsContract.Data.RAW_CONTACT_ID + "=?";
//
//////                //通过电影名称在数据库查询 电影ID
//               SQLiteDatabase db= new MyDataBaseHelper(getActivity(),"IsHit.db",null,1).getWritableDatabase();
//                Cursor cursor= db.query("IsHit",movieId,"movieName"+"=?",movieName,null,null,null);
//              if (cursor.moveToFirst()) {
//                  for (;!cursor.isAfterLast();cursor.moveToNext()){
//                     String Id= cursor.getString(cursor.getColumnIndex("movieId"));
//                       Log.i("TAG", "onItemClick: "+Id);
//                       Toast.makeText(getActivity(), ""+Id, Toast.LENGTH_SHORT).show();
//
//                  }
//               }
//               cursor.close();

            }
       });

    }


    @Override
    public void onBoxOfficeLoadEnd(BoxOffice boxOffice) {

        //清空数据
        boxOffices.clear();
        //获得到排行榜数据
        boxOffices.addAll(boxOffice.getMovies());
        for (BoxOffice.MoviesBean office : boxOffices) {


        }
        if (boxOffices != null) {
            //数据适配
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new RankingAdapter(getActivity(), boxOffices);
                    lvRanking.setAdapter(adapter);
                    //更新界面
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
