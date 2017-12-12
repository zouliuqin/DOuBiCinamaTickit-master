package com.liucheng.administrator.doubicinamatickit.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/10/29 0029.
 */

public class StreamUtil {
    public static String getStringFromStream(InputStream inputStream) {


        BufferedReader reader = null;
        String jsonBuilder = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder builder = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            jsonBuilder = builder.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBuilder;
    }

    public static byte[] getByetsFormSfream(InputStream inputStream) {
        ByteArrayOutputStream os = null;
        byte[] datas = null;
        try {
            os = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 8];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            os.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        datas = os.toByteArray();
        Log.d("TSDU",datas.toString()+"");
        return datas;

    }
}
