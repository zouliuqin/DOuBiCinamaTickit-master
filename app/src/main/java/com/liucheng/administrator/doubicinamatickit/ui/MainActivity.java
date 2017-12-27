package com.liucheng.administrator.doubicinamatickit.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.liucheng.administrator.doubicinamatickit.adapter.MyFragmentAdapter;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.BuyTicketFragment;
import com.liucheng.administrator.doubicinamatickit.module.cinema.CinemaFragment;
import com.liucheng.administrator.doubicinamatickit.module.find.FindFragment;
import com.liucheng.administrator.doubicinamatickit.module.homepage.HomeFragment;
import com.liucheng.administrator.doubicinamatickit.module.myself.MyFragment;
import com.liucheng.administrator.doubicinamatickit.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

   public String city;

    public LocationClient mLocationClient;



    private boolean isFirstLocate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        baidu();
        initialUI();

        SetListener();
    }

    private void baidu() {
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String [] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        } else {
            requestLocation();
        }
        requestLocation();
    }


    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(9999999);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("纬度：").append(location.getLatitude()).append("\n");
            currentPosition.append("经线：").append(location.getLongitude()).append("\n");
            currentPosition.append("国家：").append(location.getCountry()).append("\n");
            currentPosition.append("省：").append(location.getProvince()).append("\n");
            currentPosition.append("市：").append(location.getCity()).append("\n");
            currentPosition.append("区：").append(location.getDistrict()).append("\n");
            currentPosition.append("街道：").append(location.getStreet()).append("\n");
            currentPosition.append("定位方式：");
            if (location.getLocType() == BDLocation.TypeGpsLocation) {
                currentPosition.append("GPS");
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }

            //设置城市
           city = location.getCity().substring(0,location.getCity().length()-1);
            Log.i("TAG", "onReceiveLocation: "+city);

            MyApplication.setCityName(city);

        }


    }



    //声明控件
    ViewPager viewPager_main = null;
    RadioGroup radioGroup_bottom = null;
    MyFragmentAdapter adapter = null;
    BuyTicketFragment buyTicketFragment;
    CinemaFragment cinemaFragment;
    FindFragment findFragment;
    HomeFragment homeFragment;
    MyFragment myFragment;
public ViewPager  getViewPager_main(){
    return viewPager_main;
}

    private void initialUI() {
        //初始化控件
        viewPager_main = findViewById(R.id.mainactivity_viewPager);
        radioGroup_bottom = findViewById(R.id.include_ridiogroup_bottom);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        //初始化Fragment
        buyTicketFragment = new BuyTicketFragment();
        cinemaFragment = new CinemaFragment();
        findFragment = new FindFragment();
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        //向适配器集合中添加Fragment
        adapter.addFragment(homeFragment);
        adapter.addFragment(buyTicketFragment);
        adapter.addFragment(cinemaFragment);
        adapter.addFragment(findFragment);
        adapter.addFragment(myFragment);
        //将adpter与ViewPager进行关联
        viewPager_main.setAdapter(adapter);


    }



    private void SetListener() {
        //将viewPager_main2与radioGroup_Button进行关联
        viewPager_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup_bottom.check(R.id.radioButton_home);
                        break;
                    case 1:
                        radioGroup_bottom.check(R.id.radioButton_buy_ticket);
                        break;
                    case 2:
                        radioGroup_bottom.check(R.id.radioButton_cinema);
                        break;
                    case 3:
                        radioGroup_bottom.check(R.id.radioButton_find);
                        break;
                    case 4:
                        radioGroup_bottom.check(R.id.radioButton_my);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton_home:
                        viewPager_main.setCurrentItem(0);
                        break;
                    case R.id.radioButton_buy_ticket:
                        viewPager_main.setCurrentItem(1);
                        break;
                    case R.id.radioButton_cinema:
                        viewPager_main.setCurrentItem(2);
                        break;
                    case R.id.radioButton_find:
                        viewPager_main.setCurrentItem(3);
                        break;
                    case R.id.radioButton_my:
                        viewPager_main.setCurrentItem(4);
                        break;
                }
            }
        });


    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            showDialogView();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }


    private void showDialogView() {
        AlertDialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        builder.setMessage("确认要退出吗？");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });

        dialog = builder.create();
        dialog.show();
    }


}
