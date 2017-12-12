package com.liucheng.administrator.doubicinamatickit.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;

import com.liucheng.administrator.doubicinamatickit.util.StreamUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/10/29 0029.
 */

public class MyImageLoader {
    //设置图片的最大缓存空间，是软件最大缓存空间的1/8；
    public static LruCache<String, Bitmap> lruCache = null;

    static {
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 8);
        lruCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    //从存储中获取图片同时设置到控件上
    public static void saveBitmapFormCache(Context context, String imageUrl, ImageView imageView) {
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(imageUrl)) {
            return;
        }
        //从内存缓存中获取图片
        bitmap = getBitmapFormMomery(imageUrl);
        if (bitmap != null) {
            //如果内存当中有要使用的图片，则直接应用
            imageView.setImageBitmap(bitmap);
            return;
        }
        //如果内存中没有要应用的图片,再从文件缓存目录下去查找
        bitmap = getBitmapFormFile(context, imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //如果文件缓存中没有，则从网上异步加载图片
        loadBitmapFormHttp(context, imageView, imageUrl);


    }

    //从网上异步加载图片的方法
    private static void loadBitmapFormHttp(Context context, ImageView imageView, String imageUrl) {

    }

    //创建从网上异步加载图片的类
    public static class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
        public Context context;
        public ImageView imageView;

        public ImageAsyncTask(Context context, ImageView imageView) {
            this.context = context;
            this.imageView = imageView;
        }

        //该方法在子线程中运行，可用于执行耗时操作，在此方法中进行网络请求
        @Override
        protected Bitmap doInBackground(String... strings) {
            String path = strings[0];
            Bitmap bitmap;
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                if (inputStream != null) {
                    //对图片进行缩放处理
                    bitmap = comprossBitmap(inputStream);
                    if (bitmap != null) {
                        //缓存到内存中
                        lruCache.put(path, bitmap);
                        //缓存到文件中
                        saveBitmapToFile(context, bitmap, path);

                        return bitmap;

                    }

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        /**
         * 把图片缓存到文件中
         *
         * @param context
         * @param bitmap
         * @param path
         */
        private void saveBitmapToFile(Context context, Bitmap bitmap, String path) {


            try {
                //获得应用的缓存目录
                File cacheDir = context.getCacheDir();
                if (!cacheDir.exists()) {
                    cacheDir.mkdir();
                }
                //获得要缓存的图片的文件名
                String fileName = path.substring(path.lastIndexOf("/") + 1);
                //创建一个文件对象
                File file = new File(cacheDir,fileName);
                OutputStream os =new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,os);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }


    }

    //对图片进行缩放处理
    private static Bitmap comprossBitmap(InputStream inputStream) {
        Bitmap bitmap = null;
        //调用方法将输入字符流转换成字节流数组
        byte[] datas = StreamUtil.getByetsFormSfream(inputStream);
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置对图片进行解码时只对图片的边界进行处理
        options.inJustDecodeBounds = true;
        //对图片进行解码，该解码返回的是空，但对图片边界进行处理
        BitmapFactory.decodeByteArray(datas, 0, datas.length, options);
        //通过options获得图片边界的宽高信息
        int width = options.outWidth;
        int height = options.outHeight;
        //设置希望该图片被压缩后的目标宽高
        int targetWidth = 80;
        int targetHeight = 80;
        //设置宽高的缩放比例
        int blw = width / targetWidth;
        int blh = height / targetHeight;
        int bl = 0;
        bl = width > height ? blw : blh;
        if (bl < 1) {
            bl = 1;
        }
        options.inSampleSize = bl;
        //设置解码时不仅仅指对边界进行解码，还对图片进行解码，返回的是bitmap对象
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeByteArray(datas, 0, datas.length, options);


        return bitmap;
    }


    /**
     * 从文件缓存中查找图片
     *
     * @param context
     * @param imageUrl 获取图片的路径
     * @return
     */
    private static Bitmap getBitmapFormFile(Context context, String imageUrl) {
        Bitmap bitmap = null;
        //获得图片的缓存文件
        File cacheDir = context.getCacheDir();
        //文件名为imageUrl中最后一个/的后半部分，到时候存储的时候也得按照相同的路径名存储
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        if (cacheDir != null) {
            //该目标文件下的文件数组
            File[] files = cacheDir.listFiles();
            //遍历该数组，获取文件名相匹配的文件
            for (File file : files) {
                if (fileName.equals(file.getName())) {
                    //说明在缓存文件夹下面有我要查找的图片
                    //获得图片的bitmap形式
                    bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    return bitmap;

                }

            }


        }


        return bitmap;
    }


    /**
     * 从内存缓存中查找图片，根据imageUrl来查找，则存储到内存缓存中的时候也必须根据imageUrl来存储
     */
    private static Bitmap getBitmapFormMomery(String imageUrl) {
        Bitmap bitmap = null;
        bitmap = lruCache.get(imageUrl);

        return bitmap;
    }


}
