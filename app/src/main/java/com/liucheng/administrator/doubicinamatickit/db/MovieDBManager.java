//package com.liucheng.administrator.doubicinamatickit.db;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by JiaJi on 2015/12/15.
// */
//public class MovieDBManager {
//    private SQLiteDatabase db;
//    private List<IsHit.MsBean> data = new ArrayList<>();
//    private static MovieDBManager cooksDBManager;
//
//    private MovieDBManager(Context context) {
//        MovieDBHelper helper = new MovieDBHelper(context);
//        db = helper.getWritableDatabase();
//    }
//
//    public static MovieDBManager getCooksDBManager(Context context) {
//        if (cooksDBManager == null) {
//            cooksDBManager = new MovieDBManager(context);
//        }
//        return cooksDBManager;
//    }
//
//    /**
//     * 增添数据
//     */
//    public void insertData(List<IsHit> data) {
//        Cursor cursor = db.rawQuery("select * from " + MovieDBHelper.TABLE_TEXT + " where " + MovieDBHelper.ID + "=" + data.get(0).get,null);
//        if (cursor.getCount() == 1) {
//            cursor.close();
//            db.execSQL("update " + MovieDBHelper.TABLE_TEXT + " set " + MovieDBHelper.HISTORY_LOOK + " = " + 1 + " where " + MovieDBHelper.ID + "=" + data.getId());
//            return;
//        }
//        cursor.close();
//        String textSql = "insert into " + MovieDBHelper.TABLE_TEXT + "(" + MovieDBHelper.ID + "," + MovieDBHelper.TITLE + "," +
//                MovieDBHelper.TAGS + "," + MovieDBHelper.IMTRO + "," + MovieDBHelper.INGREDIENTS + "," + MovieDBHelper.BURDEN + "," +
//                MovieDBHelper.ALBUMS + "," +
//                MovieDBHelper.HISTORY_LOOK + ")" +
//                " values('" + data.getId() + "','" + data.getTitle() + "','" + data.getTags() + "','" + data.getImtro() + "','" + data.getIngredients()
//                + "','" + data.getBurden() + "','" + data.getAlbums().get(0) + "',1)";
//        db.execSQL(textSql);
//        //
//        for (int i = 0, length = data.getSteps().size(); i < length; i++) {
//            String imgsSql = "insert into " + MovieDBHelper.TABLE_IMGS + "(" + MovieDBHelper.ID + "," + MovieDBHelper.IMG + "," + MovieDBHelper.STEP + ")" + " values('" + data.getId() + "','" +
//                    data.getSteps().get(i).getImg() + "','" + data.getSteps().get(i).getStep() + "')";
//            db.execSQL(imgsSql);
//        }
//    }
//
////    /**
////     * 删除数据
////     *
////     * @param data
////     */
////    public void delData(List<IsHit.MsBean> data) {
////        if (data == null) {
////            Cursor cursor = db.rawQuery("select * from " + MovieDBHelper.TABLE_TEXT, null);
////            while (cursor.moveToNext()) {
////                if (cursor.getInt(cursor.getColumnIndex(MovieDBHelper.HISTORY_LOOK)) == 1)//删除浏览历史的数据
////                {
////                    if (cursor.getInt(cursor.getColumnIndex(MovieDBHelper.MY_LIKE)) == 1){
////                        db.execSQL(" update  "+MovieDBHelper.TABLE_TEXT+" set "+MovieDBHelper.HISTORY_LOOK+" =0"+" where "+MovieDBHelper.ID+" = "+cursor.getInt(cursor.getColumnIndex(MovieDBHelper.ID)));
////                        continue;}
////                    String textSql = "delete from " + MovieDBHelper.TABLE_TEXT + " where "
////                            + MovieDBHelper.ID + "=" + cursor.getInt(cursor.getColumnIndex(MovieDBHelper.ID));
////                    db.execSQL(textSql);
////                    String imgsSql = "delete from " + MovieDBHelper.TABLE_IMGS + " where "
////                            + MovieDBHelper.ID + "=" + cursor.getInt(cursor.getColumnIndex(MovieDBHelper.ID));
////                    db.execSQL(imgsSql);
////                }
////            }
////            cursor.close();
////        } else {
////            String textSql = "delete from " + MovieDBHelper.TABLE_TEXT + " where "
////                    + MovieDBHelper.ID + "=" + data.getId();
////            db.execSQL(textSql);
////            String imgsSql = "delete from " + MovieDBHelper.TABLE_IMGS + " where "
////                    + MovieDBHelper.ID + "=" + data.getId();
////            db.execSQL(imgsSql);
////        }
////    }
//
////    /**
////     * 修改数据，default 0（不喜欢） default 1 （喜欢）
////     *
////     * @param data
////     * @param isLike 是否收藏
////     */
////    public void updateData(List<IsHit.MsBean> data, boolean isLike) {
////        String textSql = "update " + MovieDBHelper.TABLE_TEXT + " set "
////                + MovieDBHelper.MY_LIKE + "='" + (isLike ? 1 : 0) + "' where " + MovieDBHelper.ID + "=" + data.getId();
////        db.execSQL(textSql);
////    }
////
////    public ShowCookersInfo getData(boolean isHistory, boolean isLike) {
////        ShowCookersInfo info = new ShowCookersInfo();
////        String textSql;
////        if (isHistory) {
////            textSql = "select * from " + MovieDBHelper.TABLE_TEXT + " where " + MovieDBHelper.HISTORY_LOOK + " = " + 1;
////
////        } else {
////            textSql = "select * from " + MovieDBHelper.TABLE_TEXT + " where " + MovieDBHelper.MY_LIKE + "=" + (isLike ? 1 : 0);
////        }
////
////        Cursor textCursor = db.rawQuery(textSql, null);
////        ShowCookersInfo.Result result = new ShowCookersInfo.Result();
////        info.setResult(result);
////        List<ShowCookersInfo.Result.Data> datas = new ArrayList<>();
////        result.setData(datas);
////        ShowCookersInfo.Result.Data data;
////        while (textCursor.moveToNext()) {
////            data = new ShowCookersInfo.Result.Data();
////            data.setId(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.ID)));
////            data.setTitle(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.TITLE)));
////            data.setTags(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.TAGS)));
////            data.setImtro(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.IMTRO)));
////            data.setIngredients(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.INGREDIENTS)));
////            data.setBurden(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.BURDEN)));
////            List<String> albums = new ArrayList<>();
////            data.setAlbums(albums);
////            albums.add(textCursor.getString(textCursor.getColumnIndex(MovieDBHelper.ALBUMS)));
////
////            List<ShowCookersInfo.Result.Data.Steps> stepses = new ArrayList<>();
////            data.setSteps(stepses);
////            ShowCookersInfo.Result.Data.Steps steps;
////            String imgsSql = "select * from " + MovieDBHelper.TABLE_IMGS + " where " + MovieDBHelper.ID + "=" + textCursor.getInt(textCursor.getColumnIndex(MovieDBHelper.ID));
////            Cursor imgsCursor = db.rawQuery(imgsSql, null);
////            while (imgsCursor.moveToNext()) {
////                steps = new ShowCookersInfo.Result.Data.Steps();
////                steps.setImg(imgsCursor.getString(imgsCursor.getColumnIndex(MovieDBHelper.IMG)));
////                steps.setStep(imgsCursor.getString(imgsCursor.getColumnIndex(MovieDBHelper.STEP)));
////                stepses.add(steps);
////            }
////            datas.add(data);
////            imgsCursor.close();
////        }
////        textCursor.close();
////        return info;
////    }
//
//    /**
//     * 当前id的菜谱是否是添加了收藏
//     *
//     * @param id
//     * @return
//     */
//    public boolean isLikeNowCook(String id) {
//        boolean isLike;
//        Cursor cursor = db.rawQuery("select " + MovieDBHelper.MY_LIKE + " from " + MovieDBHelper.TABLE_TEXT + " where " + MovieDBHelper.ID + "=" + id, null);
//        cursor.moveToNext();
//        isLike = cursor.getInt(0) == 1;
//        cursor.close();
//        return isLike;
//    }
//
//    public List<IsHit.MsBean> getData() {
//        return data;
//    }
//
//    public void setData(List<IsHit.MsBean> data) {
//        this.data = data;
//    }
//}
