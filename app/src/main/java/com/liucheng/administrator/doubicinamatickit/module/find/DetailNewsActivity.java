package com.liucheng.administrator.doubicinamatickit.module.find;

import android.app.Activity;
import android.app.admin.DeviceAdminInfo;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.DetailNew;
import com.liucheng.administrator.doubicinamatickit.module.find.data.DetailNewData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.annotation.Documented;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

public class DetailNewsActivity extends AppCompatActivity implements DetailNewData.DetailNewDataLoadListener{
    DetailNew.DataBean.DetailBean dataBean = new DetailNew.DataBean.DetailBean();

    @BindView(R.id.text_Content)
  WebView textContent;

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String NewsId = intent.getStringExtra("NewsId");
        DetailNewData.getNewsData(this,NewsId);







    }

    private void initiaWebView(String html1) {
        //声明WebSettings子类
        WebSettings webSettings = textContent.getSettings();

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);}
//启用js
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        //解决图片不显示
        webSettings.setBlockNetworkImage(false);


        //缩放操作
//        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件




        //设置自适应屏幕，两者合用
//        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        boolean a =     textContent.getSettings().getLoadsImagesAutomatically();
        Log.d("---------=+++++++",a+"");

        String html =html1;

        Document doc =  Jsoup.parse(html);
        DisplayMetrics metric = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metric);

        Elements elementImgs = doc.getElementsByTag("img");//获取所有img标签
        for (Element img : elementImgs) {
            img.attr("width", (int)(metric.widthPixels/metric.density-15) + "px");//设置width属性
        }
        Elements elementImg = doc.getElementsByTag("video");//获取所有img标签
        for (Element video : elementImg) {
            video.attr("width", (int)(metric.widthPixels/metric.density-15) + "px");//设置width属性

        }
        Elements html2 = doc.select("i");
        html2.html("<i><i/>");
//        Elements html3 = doc.select("");

//        Elements  ac =html.not("a");
//        Elements ac = html2.not("i");
        String content1 = doc.toString();
        String  content = content1.replace("时光网讯"," ");
        String str = "'\\'";
        String sb = str.replace("'","");
        Log.d("88888888888",sb);

        String Content= content.replaceAll("\\\\","");
        String ab = Content.replaceAll("&quot;","");
//        String m = "src=""";
        String av = ab.replaceAll("src","b-src");
//        Log.d("]]]]]]]]]]",av);
        String ac = av.replaceAll("data-b-src","src");


        Log.d("000000000000",ac);




        textContent.loadDataWithBaseURL("", ac, "text/html", "utf-8", null);


    }


    @Override
    public void onDetailNewDataLoadEnd(DetailNew detailNewData) {
        dataBean = detailNewData.getData().getDetail();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initiaWebView(dataBean.getContent());
            }
        });


        Log.d("7777777777777777",detailNewData.getData().getDetail().getContent());
    }
}
