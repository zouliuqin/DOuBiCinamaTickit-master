package com.liucheng.administrator.doubicinamatickit.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHitData;
import com.liucheng.administrator.doubicinamatickit.sql.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends Activity implements IsHitData.IsHitLoadListener {
    private ViewFlipper viewFlipper;
    private Button button;
    //声明控件
    private ImageView iv_Amn;
    //声明一个动画对象
    private Animation main_an;

    //正在热映
    List<IsHit.MsBean> ms = new ArrayList<>();
    //偏好设置数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initialUI();
        //初始化控件
        iv_Amn = findViewById(R.id.src_splash);
        //将一个动画文件转换成一个动画对象
        main_an = AnimationUtils.loadAnimation(this,R.anim.shade);
        //将动画对象应用到控件上
        iv_Amn.setAnimation(main_an);
        //监听动画的状态
        main_an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.shade,R.anim.shade_out);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        //初始化正在热映电影数据,设置偏好设置保存在本地,用于票房榜查询电影详情
        //initIsHit();


    }

    //初始化正在热映电影数据,设置偏好设置保存在本地,用于票房榜查询电影详情
    private void initIsHit() {
        IsHitData.getIIsHitData(this);
    }

    private void initialUI() {
//        viewFlipper = findViewById(R.id.splash_viewFlipper);
        //        ImageView imageView = new ImageView(this);
        //        imageView.setImageResource(R.drawable.ic_cinema_selecte2);
        //        ImageView imageView1 = new ImageView(this);
        //        imageView1.setImageResource(R.drawable.ic_find_selecte2);
        //       viewFlipper.addView(imageView);
        //       viewFlipper.addView(imageView1);
        //       viewFlipper.setFlipInterval(1000);
        //       viewFlipper.startFlipping();



    }


    @Override
    public void onIsHitLoadEnd(IsHit isHit) {

        ms.addAll(isHit.getMs());
        SQLiteDatabase db= new MyDataBaseHelper(this,"IsHit.db",null,1).getWritableDatabase();
        //先清空数据表，再添加数据
        db.execSQL("delete from IsHit;");
        ContentValues cv = new ContentValues();
        //添加当天正在热映的电影编号和电影名称在数据库，方便后期排行榜调用
        for(int i=0 ; i <ms.size();i++){
            Log.i("TAG", "movieId: "+ms.get(i).getId());
            Log.i("TAG", "movieName: "+ms.get(i).getT());
            cv.put("movieId",ms.get(i).getId());
            cv.put("movieName",ms.get(i).getT());
            db.insert("IsHit", null, cv);
        }

    }
}
