package com.liucheng.administrator.doubicinamatickit.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;
import com.liucheng.administrator.doubicinamatickit.entity.MovieIsHit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/10/29 0029.
 */

public class HttpManagerHit {
    static Context context;
    static MovieIsHit movieIsHit = null;

    public static MovieIsHit getIsHitData() {

        BufferedReader reader = null;
        try {
            int Locationid = LocationId.getLocationId(context, R.raw.json);


            URL url = new URL(IUrl.MOVIES_IS_HIT + Locationid);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder builder = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String str = builder.toString();
            Gson gson = new Gson();
            movieIsHit = gson.fromJson(str,MovieIsHit.class);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return movieIsHit;
    }







}
