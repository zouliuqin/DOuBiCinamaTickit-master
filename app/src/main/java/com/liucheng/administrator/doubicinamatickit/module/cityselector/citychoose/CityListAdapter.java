package com.liucheng.administrator.doubicinamatickit.module.cityselector.citychoose;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;


import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.module.cityselector.database.City;

import java.util.List;

/**
 * Created by Luojingjing on 2017/11/14.
 * 城市列表的主要适配器
 */

public class CityListAdapter extends BaseAdapter {
    private static final String TAG = "CityListAdapter";
    private Context context;
    private LayoutInflater inflater;
    private List<City> list;
    private List<City> hotList;
    private List<String> hisList;
    final int VIEW_TYPE = 4;
    private String[] sections;// 存放存在的汉语拼音首字母
    private String locateCity;
    private String currentCity;

    private OnCityClickListener onCityClickListener;

    public CityListAdapter(Context context, List<City> list,
                           List<City> hotList, List<String> hisList) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.hotList = hotList;
        this.hisList = hisList;
        sections = new String[list.size()];

    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(Context context, List<City> list,
                               List<City> hotList, List<String> hisList) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.hotList = hotList;
        this.hisList = hisList;
        sections = new String[list.size()];
        notifyDataSetChanged();
    }

    //    @Override
    //    public Object[] getSections() {
    //        return null;
    //    }
    //
    //    @Override
    //    public int getPositionForSection(int sectionIndex) {
    //        for (int i = 0; i < getCount(); i++) {
    //            String sortStr = list.get(i).getPinyi();
    //            char firstChar = sortStr.toUpperCase().charAt(0);
    //            if (firstChar == sectionIndex) {
    //                return i;
    //            }
    //        }
    //        return -1;
    //    }
    //
    //    @Override
    //    public int getSectionForPosition(int position) {
    //        return list.get(position).getPinyi().charAt(0);
    //    }

    public interface OnCityClickListener {
        void onCityClick(String city);

    }

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    public void setLocateCity(String locateCity) {
        this.locateCity = locateCity;
    }


    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
    }

    @Override
    public int getItemViewType(int position) {
        return position < 3 ? position : 3;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView city;
        int viewType = getItemViewType(position);
        Log.i(TAG, "getView()-----viewType :" + viewType);
        if (viewType == 0) { // 定位
            convertView = inflater.inflate(R.layout.city_locate_item, null);
            city = (TextView) convertView.findViewById(R.id.city_locate_item_city);
            city.setText(locateCity);
        } else if (viewType == 1) { // 已访问城市
            convertView = inflater.inflate(R.layout.city_recent_item, null);
            GridView recentCity = (GridView) convertView
                    .findViewById(R.id.recent_city_grid);
            recentCity
                    .setAdapter(new CityHisListAdapter(context, this.hisList));
            recentCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {
                    currentCity = hisList.get(position);
                    //refreshCurrentCity(currentCity);
                    onCityClickListener.onCityClick(currentCity);
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //点击选中的城市，关闭当前界面,把当前城市记录下。
                            MyApplication.setCityName(currentCity);
                            ((Activity) context).finish();

                        }
                    });

                }
            });
        } else if (viewType == 2) {
            convertView = inflater.inflate(R.layout.city_recent_item, null);
            final GridView hotCity = (GridView) convertView
                    .findViewById(R.id.recent_city_grid);
            hotCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    currentCity = hotList.get(position).getName();
                    onCityClickListener.onCityClick(currentCity);
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //点击选中的城市，关闭当前界面,把当前城市记录下。
                            MyApplication.setCityName(currentCity);
                            ((Activity) context).finish();
                           // Toast.makeText(context, currentCity, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });
            hotCity.setAdapter(new CityHotListAdapter(context, this.hotList));
            TextView hotHint = (TextView) convertView
                    .findViewById(R.id.city_recent_title);
            ImageView hotImg = (ImageView) convertView.findViewById(R.id.hotCity_imagView);
            hotImg.setImageResource(R.drawable.fire);

            hotHint.setText("热门城市");
        } else {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.city_list_item, null);
                holder = new ViewHolder();
                holder.alpha = (TextView) convertView
                        .findViewById(R.id.city_item_alpha);
                holder.name = (TextView) convertView
                        .findViewById(R.id.city_item_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position >= 1) {
                holder.name.setText(list.get(position).getName());
                Log.d("YYYYYYYYYYYYYYYYYYYYYY", list.toString());
                String currentStr = PinyinUtil.getAlpha(list.get(position).getPinyi());
                String previewStr = (position - 1) >= 0 ? PinyinUtil.getAlpha(list
                        .get(position - 1).getPinyi()) : " ";
                if (!previewStr.equals(currentStr)) {
                    holder.alpha.setVisibility(View.VISIBLE);
                    holder.alpha.setText(currentStr);
                } else {
                    holder.alpha.setVisibility(View.GONE);
                }


            }
        }
        return convertView;
    }

    private class ViewHolder {
        TextView alpha; // 首字母标题
        TextView name; // 城市名字
    }

}
