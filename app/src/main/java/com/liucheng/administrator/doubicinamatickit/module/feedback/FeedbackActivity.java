package com.liucheng.administrator.doubicinamatickit.module.feedback;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.Feedback;
import com.liucheng.administrator.doubicinamatickit.entity.User;
import com.liucheng.administrator.doubicinamatickit.util.Utils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadBatchListener;

public class FeedbackActivity extends AppCompatActivity {

    @BindView(R.id.et_feedback_describe)
    EditText etFeedbackDescribe;
    @BindView(R.id.iv_feedback_add_image)
    ImageView ivFeedbackAddImage;
    @BindView(R.id.et_feedback_contact)
    EditText etFeedbackContact;
    @BindView(R.id.but_feedback_submit)
    Button butFeedbackSubmit;
    @BindView(R.id.rl_feedback_img)
    RelativeLayout rlFeedbackImg;

    /**
     * 反馈问题描述
     */
    private String FeedbackDescribe;
    /**
     * 反馈问题图片
     */

    private ArrayList<ImageView> imageViews = new ArrayList<>();
    /**
     * 选择的图片
     */
    private List<LocalMedia> selectList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.iv_feedback_add_image, R.id.but_feedback_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_feedback_add_image:
                //用户上传图片，跳转到图册
                pictureSelector();

                break;
            case R.id.but_feedback_submit:
                //提交反馈


                //判断用户是否输入了内容 ，如果输入了内容才允许提交
                if (etFeedbackDescribe.getText().length() > 0) {
                    //提交数据。

                    //提交数据到bmob
                    final Feedback feedback = new Feedback();
                    feedback.setDescribe(etFeedbackDescribe.getText().toString());
                    feedback.setContact(etFeedbackContact.getText().toString());
                    feedback.setUser(BmobUser.getCurrentUser(User.class));
                    feedback.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                //判断是否有图片
                                if (imageViews.size() > 0) {
                                    String[] imagePaths = new String[imageViews.size()];
                                    for (int i = 0; i < imageViews.size(); i++) {
                                        ImageView imageView = imageViews.get(i);
                                        imagePaths[i] = (String) imageView.getTag();
                                    }
                                    //批量上传图片
                                    BmobFile.uploadBatch(imagePaths, new UploadBatchListener() {
                                        @Override
                                        public void onSuccess(List<BmobFile> list, List<String> list1) {
                                            //上传完成！
                                            feedback.setImg(list1);

                                            feedback.update(new UpdateListener() {
                                                @Override
                                                public void done(BmobException e) {
                                                    if (e == null) {
                                                        Toast.makeText(FeedbackActivity.this, "谢谢您的反馈意见！", Toast.LENGTH_SHORT).show();
                                                        //清空界面
                                                        rlFeedbackImg.removeAllViews();
                                                        etFeedbackContact.setText("");
                                                        etFeedbackDescribe.setText("");
                                                        //设置加号
                                                        setIvClick(0);
                                                    } else {
                                                        Toast.makeText(FeedbackActivity.this, "提交失败！", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                        }

                                        @Override
                                        public void onProgress(int i, int i1, int i2, int i3) {
                                        }

                                        @Override
                                        public void onError(int i, String s) {
                                            Utils.showToast(FeedbackActivity.this, "发送失败：" + s);
                                        }
                                    });
                                } else {
                                    // sendFinish();
                                    Utils.showToast(FeedbackActivity.this, "保存成功！");
                                }

                            } else {
                                Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                            }
                        }
                    });

                } else {
                    Toast.makeText(this, "请输入反馈的问题或意见", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    private void pictureSelector() {
        PictureSelector.create(FeedbackActivity.this)
                .openGallery(PictureMimeType.ofAll())//全部PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .maxSelectNum(3)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(true) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(false)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .glideOverride(160, 160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(3, 2)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(true)// 是否显示gif图片 true or false
                //                        .compressSavePath(getPath())//压缩图片保存地址
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(true)// 是否开启点击声音 true or false
                .selectionMedia(null)// 是否传入已选图片 List<LocalMedia> list
                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                .cropCompressQuality(90)// 裁剪压缩质量 默认90 int
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .cropWH(160, 160)// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .videoQuality(0)// 视频录制质量 0 or 1 int
                .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
                .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
                .recordVideoSecond(60)//视频秒数录制 默认60s int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    //相片回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    //                    // 图片选择结果回调
                    //                    // PictureSelector.obtainMultipleResult(data);
                    //
                    //                    //在界面中显示已经选择回来的图片
                    //                    // Picasso.with(MyApplication.getContext()).load().into(ivMySetImg);
                    //                    Log.i("TAG", "onActivityResult: "+ PictureSelector.obtainMultipleResult(data).get(0).getPath());
                    //                    showImage(PictureSelector.obtainMultipleResult(data).get(0).getPath());

                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);

                    //在界面中显示已经选择回来的图片

                    loadImages(rlFeedbackImg, selectList);
                    break;
            }
        }
    }


    private void loadImages(RelativeLayout layout_images, List<LocalMedia> imagePaths) {

        //删除之前显示所有图片
        layout_images.removeAllViews();

        //获取屏幕宽度
        int scrrenWidth = getResources().getDisplayMetrics().widthPixels;
        int size = (scrrenWidth - 2 * 8) / 3;


        for (int i = 0; i < imagePaths.size(); i++) {
            ImageView iv = new ImageView(this);

            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            File f = new File(imagePaths.get(i).getPath());
            Picasso.with(this).load(f).into(iv);
            iv.setTag(imagePaths.get(i).getPath());
            imageViews.add(iv);

            iv.setX(i % 3 * (size + 8));
            iv.setY(i / 3 * (size + 8));
            layout_images.addView(iv, new RelativeLayout.LayoutParams(size, size));
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    //  Utils.showToast(PostTradeActivity.this,"!!!!!!!!!!!!!!!!!!");
                    pictureSelector();
                }
            });

        }
        if (imagePaths.size() < 3) {
            int j = imagePaths.size();
            setIvClick(j);
        }


        //动态改变 当复用控件中用到动态改变的控件时自动适应高度可能会出问题

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layout_images.getLayoutParams();

        int line = imagePaths.size() % 4 == 0 ? imagePaths.size() / 4 : imagePaths.size() / 4 + 1;
        lp.height = line * (size + 8);

    }

    //加号
    private void setIvClick(int i) {
        //获取屏幕宽度
        int scrrenWidth = getResources().getDisplayMetrics().widthPixels;
        int size = (scrrenWidth - 2 * 8) / 3;
        ImageView iv = new ImageView(this);
        Picasso.with(this).load(R.mipmap.ic_add).into(iv);
        iv.setX(i % 3 * (size + 8));
        iv.setY(i / 3 * (size + 8));
        rlFeedbackImg.addView(iv, new RelativeLayout.LayoutParams(size, size));


        // loadImages(rlProductDetails, selectList);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 进入相册 以下是例子：用不到的api可以不写
                //  Utils.showToast(PostTradeActivity.this,"!!!!!!!!!!!!!!!!!!");
                pictureSelector();
            }
        });
    }
    //
    //    private void showImage(final String imagePath) {
    //        new Handler().post(new Runnable() {
    //            @Override
    //            public void run() {
    //                File file = new File(imagePath);
    //
    //                if (file.exists()) {
    //
    //                    Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
    //                    ivMySetImg.setImageBitmap(bitmap);
    //                } else {
    //                    Toast.makeText(FeedbackActivity.this, "选择头像失败", Toast.LENGTH_LONG).show();
    //                }
    //            }
    //        });
    //    }
}
