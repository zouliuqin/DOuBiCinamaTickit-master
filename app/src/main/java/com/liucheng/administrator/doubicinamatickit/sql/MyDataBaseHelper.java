package com.liucheng.administrator.doubicinamatickit.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 邹柳钦 on 2017/12/1 0001.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {

    public  static  final String CREATE_ISHIT="create table IsHit (id integer primary key autoincrement,movieId integer,movieName text)";

    private  Context context;

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ISHIT);
        Log.i("TAG", "onCreate: 创建ISHIT表成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
