//package com.liucheng.administrator.doubicinamatickit.db;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.bumptech.glide.Glide;
//
///**
// * Created by JiaJi on 2015/12/15.
// */
//public class MovieDBHelper extends SQLiteOpenHelper {
//    public static final String DB_NAME = "movie.db";
//    public static final int VERSION = 1;
//    /**
//     * 是否添加了收藏：0不是，1是
//     */
//    public static final String MY_LIKE = "my_like";
//    /**
//     * 是否是观看历史：0不是，1是
//     */
//    public static final String HISTORY_LOOK = "history";
//
//    public static final String TABLE_TEXT = "movie_info";
//
//    public static final String ID = "_id";
//    /**
//     * 电影名称
//     */
//    public static final String TITLE = "movie_name";
//    /**
//     * 电影ID
//     */
//    public static final String MOVIE_ID = "movie_id";
//
//    /**
//     * 图片
//     */
//    public static final String MOVE_IMG = "movie_img";
//    /**
//     * 电影描述
//     */
//    public static final String CONTENT = "movie_content";
//    /**
//     * 演员
//     */
//    public static final String ACTORS = "movie_actors";
//    /**
//     * 评分
//     */
//    public static final String GRADER = "movie_grader";
//
//
//    public static final String CREATE_TEXT_TABLE = "create table " + TABLE_TEXT + "(" +
//            ID + " integer primary key," +
//            TITLE + "," +
//            MOVIE_ID + "," +
//            MOVE_IMG + "," +
//            CONTENT + "," +
//            ACTORS + "," +
//            GRADER + "," +
//            HISTORY_LOOK + " integer default 0," +
//            MY_LIKE + " integer default 0)";
//
//
//    public static final String TABLE_IMGS = "movie_imgs";
//    public static final String IMG = "img";
//
//    public static String CREATE_IMGS_TABLE = "create table " + TABLE_IMGS + "(" +
//            ID + " integer," +
//            IMG + "," + ")";
//
//    public MovieDBHelper(Context context) {
//        super(context, DB_NAME, null, VERSION);
//    }
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TEXT_TABLE);
//        db.execSQL(CREATE_IMGS_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//}
