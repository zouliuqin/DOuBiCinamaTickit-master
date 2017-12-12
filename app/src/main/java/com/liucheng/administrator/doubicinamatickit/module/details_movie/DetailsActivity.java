package com.liucheng.administrator.doubicinamatickit.module.details_movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.DetailsData;

public class DetailsActivity extends AppCompatActivity implements DetailsData.DetailsDataLoadListener {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        DetailsData.getIIsHitData(this);
        webView = findViewById(R.id.webView);


    }

    @Override
    public void onIsHitLoadEnd(final Details details) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webView.loadDataWithBaseURL(null, Html.fromHtml(details.getContent())+"", "text/html",  "utf-8", null);



            }
        });

    }
}
