package com.liucheng.administrator.doubicinamatickit.module.details_movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.DetailsData;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity implements DetailsData.DetailsDataLoadListener {
    WebView webView;
    Details detail = new Details();
    @BindView(R.id.image_movie)
    ImageView imageMovie;
    @BindView(R.id.text_movieName)
    TextView textMovieName;
    @BindView(R.id.text_movieNameEn)
    TextView textMovieNameEn;
    @BindView(R.id.text_movieDate)
    TextView textMovieDate;
    @BindView(R.id.text_movieDuration)
    TextView textMovieDuration;
    @BindView(R.id.text_movieDirector)
    TextView textMovieDirector;
    @BindView(R.id.text_movieAct)
    TextView textMovieAct;
    @BindView(R.id.text_movieType)
    TextView textMovieType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String cinameId = intent.getStringExtra("cinameId");
        Log.d("9999999999", cinameId);
        DetailsData.getIIsHitData(this, cinameId);
//        Log.d("rrrrrrrrrrrrrr",detail.getData().getBasic().getStory());




    }

    private void initiaData() {
        Picasso.with(this).load(detail.getData().getBasic().getImg()).into(imageMovie);
        textMovieName.setText(detail.getData().getBasic().getName());
if (detail.getData().getBasic().getNameEn().length()>1){
    textMovieNameEn.setText(detail.getData().getBasic().getNameEn());
}else {
    textMovieNameEn.setText("...");
}


        textMovieDate.setText(detail.getData().getBasic().getReleaseDate().substring(0,4));
if (detail.getData().getBasic().getMins().length()>1){
    textMovieDuration.setText(detail.getData().getBasic().getMins());
}else {
    textMovieDuration.setText("....");
}
if (detail.getData().getBasic().getDirector().getName().length()>1){
    textMovieDirector.setText(detail.getData().getBasic().getDirector().getName());
}else {
    textMovieDirector.setText("...");
}

if (detail.getData().getBasic().getActors().get(0).getName().length()>1){
    String act1 = detail.getData().getBasic().getActors().get(0).getName();
    String act2 = detail.getData().getBasic().getActors().get(1).getName();

    textMovieAct.setText(act1+" "+act2 );
}else {
    textMovieAct.setText("...");
}



        textMovieType.setText(detail.getData().getBasic().getType()+"");


    }

    @Override
    public void onIsHitLoadEnd(final Details details) {
        detail = details;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("666666666", detail.getData().getBasic().getStory() + "");

                initiaData();
            }
        });

    }

    @OnClick(R.id.image_movie)
    public void onViewClicked() {
    }
}
