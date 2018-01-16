package com.liucheng.administrator.doubicinamatickit.module.photo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.liucheng.administrator.doubicinamatickit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * 点击剧照呈现大照片
 */
public class PhotoActivity extends AppCompatActivity {

    @BindView(R.id.photo)
    PhotoView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        String img = getIntent().getStringExtra("img");

        Glide.with(this).load(img).into(photo);

    }
}
