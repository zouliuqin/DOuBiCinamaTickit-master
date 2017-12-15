package com.liucheng.administrator.doubicinamatickit.module.details_movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.DetailsData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DetailsActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        String cinameId = intent.getStringExtra("cinameId");
        Log.d("9999999999",cinameId);
//        DetailsData.getIIsHitData(this,cinameId);
        webView = findViewById(R.id.webView);


    }

//    @Override
//    public void onIsHitLoadEnd(final Details details) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                String html = details.getContent();
//                Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
//                Element link = doc.select("div").get(2);//查找第一个a元素
//                String linkText = link.text(); // "example""//取得链接地址中的文本
//                Log.d("ddddddddddddddddd",linkText+"");
//                webView.loadDataWithBaseURL(null, Html.fromHtml(linkText)+"", "text/html",  "utf-8", null);
//            }
//        });
//
//    }
}
