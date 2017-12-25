package com.liucheng.administrator.doubicinamatickit.module.basicsettings;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.util.CacheDataManager;
import com.liucheng.administrator.doubicinamatickit.util.DateUtil;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

public class BasicSettingsActivity extends AppCompatActivity {

    @BindView(R.id.ll_no_inform)
    LinearLayout llNoInform;
    @BindView(R.id.ll_notification_manager)
    LinearLayout llNotificationManager;
    @BindView(R.id.ll_version_updates)
    LinearLayout llVersionUpdates;
    @BindView(R.id.ll_clear_cache)
    LinearLayout llClearCache;
    @BindView(R.id.but_log_out)
    Button butLogOut;
    @BindView(R.id.tv_cache)
    TextView tvCache;

    @BindView(R.id.tv_no_disturbing_time_start)
    TextView tvNoDisturbingTimeStart;
    @BindView(R.id.tv_no_disturbing_time_end)
    TextView tvNoDisturbingTimeEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_settings);
        ButterKnife.bind(this);


        initUi();


    }

    private void initUi() {
        //设置缓存
        try {
            tvCache.setText(CacheDataManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnClick({R.id.ll_no_inform, R.id.ll_notification_manager, R.id.ll_version_updates, R.id.ll_clear_cache, R.id.but_log_out, R.id.tv_no_disturbing_time_start, R.id.tv_no_disturbing_time_end})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.ll_notification_manager:
                //通知管理
                Intent intent = new Intent(BasicSettingsActivity.this, NotificationManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_version_updates:
                //版本更新
                Toast.makeText(this, "您的版本已经是最新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_clear_cache:
                //弹出清除缓存对话框
                showClearCacheDialog();
                break;
            case R.id.but_log_out:
                //登出
                showLogOutDialog();

                break;
            case R.id.tv_no_disturbing_time_end:
                //免打扰结束时间
                //时间选择器
                TimePickerView pvTime_end = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调


                        tvNoDisturbingTimeEnd.setText(DateUtil.getTime(date));
                    }
                }).setType(new boolean[]{false, false, false, true, true, false})
                        .build();
                //  pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime_end.show();
                break;
            case R.id.tv_no_disturbing_time_start:

                //免打扰开始时间
                //时间选择器
                TimePickerView pvTime_start = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调


                        tvNoDisturbingTimeStart.setText(DateUtil.getTime(date));
                    }
                }).setType(new boolean[]{false, false, false, true, true, false})
                        .build();
                //  pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime_start.show();

                break;
        }
    }


    /**
     * 退出系统对话框
     */
    private void showLogOutDialog() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(BasicSettingsActivity.this);


        normalDialog.setMessage("确定退出登录?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //退出系统
                        BmobUser.logOut();   //清除缓存用户对象
                        BmobUser currentUser = BmobUser.getCurrentUser(); // 现在的currentUser是null了
                       // Toast.makeText(BasicSettingsActivity.this, "" + currentUser, Toast.LENGTH_SHORT).show();
                    finish();
                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }


    /**
     * 清除缓存对话框
     */
    private void showClearCacheDialog() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(BasicSettingsActivity.this);


        normalDialog.setMessage("确定清除缓存?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //清除缓存

                        new Thread(new clearCache()).start();

                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }

    /**
     * 清除缓存
     */

    class clearCache implements Runnable {

        @Override

        public void run() {

            try {

                CacheDataManager.clearAllCache(BasicSettingsActivity.this);

                Thread.sleep(3000);

                if (CacheDataManager.getTotalCacheSize(BasicSettingsActivity.this).startsWith("0")) {

                    handler.sendEmptyMessage(0);

                }

            } catch (Exception e) {

                return;

            }

        }

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {

            switch (msg.what) {

                case 0:

                    Toast.makeText(BasicSettingsActivity.this, "清理完成", Toast.LENGTH_SHORT).show();

                    try {

                        tvCache.setText(CacheDataManager.getTotalCacheSize(BasicSettingsActivity.this));

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

            }

        }

        ;

    };


}
