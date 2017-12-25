package com.liucheng.administrator.doubicinamatickit.module.myself;

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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.User;
import com.liucheng.administrator.doubicinamatickit.module.login.LoginActivity;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import de.hdodenhof.circleimageview.CircleImageView;

public class MySetActivity extends AppCompatActivity {

    @BindView(R.id.ib_include_back)
    ImageButton ibIncludeBack;
    @BindView(R.id.tv_my_set_username)
    TextView tvMySetUsername;
    @BindView(R.id.iv_my_set_img)
    CircleImageView ivMySetImg;
    @BindView(R.id.et_my_set_nicename)
    EditText etMySetNicename;
    @BindView(R.id.rb_my_set_man)
    RadioButton rbMySetMan;
    @BindView(R.id.rb_my_set_women)
    RadioButton rbMySetWomen;
    @BindView(R.id.iv_my_set_password)
    ImageView ivMySetPassword;

    @BindView(R.id.tv_include_login_title)
    TextView tvIncludeLoginTitle;
    @BindView(R.id.ll_my_set_password)
    LinearLayout llMySetPassword;
    @BindView(R.id.but_my_set_submit)
    Button butMySetSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_set);
        ButterKnife.bind(this);

        //修改标题
        tvIncludeLoginTitle.setText("个人信息");
        //获取用户信息
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            //设置用户名
            tvMySetUsername.setText(bmobUser.getUsername());
        } else {
            Toast.makeText(MyApplication.getContext(), "请先登录！", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(MySetActivity.this, LoginActivity.class);
            startActivity(intent2);
        }

    }

    @OnClick({R.id.ib_include_back, R.id.but_my_set_submit, R.id.iv_my_set_img, R.id.ll_my_set_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_include_back:
                finish();
                break;

            case R.id.iv_my_set_img:
                //点击头像
                pictureSelector();
                break;
            case R.id.ll_my_set_password:
                //修改密码
                break;
            case R.id.but_my_set_submit:

                //保存
                submit();
                break;

        }
    }

    private void submit() {
//
//        final User user = new User();
//        user.setNickname(etMySetNicename.getText().toString());
//
//        if (rbMySetMan.isChecked()){
//            user.setGender("1");
//        }else {
//            user.setGender("2");
//        }
//
//
//
//        //得到当前登录的用户
//        User currentUser = BmobUser.getCurrentUser(User.class);
//
//        user.update(currentUser.getObjectId(), new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if (e == null) {
//
//
//                    if (imagePath!=null) {//需要修改头像
//
//                        //上传图片
//                        final BmobFile uploadHead = new BmobFile(new File(imagePath));
//
//                        final KProgressHUD hud = KProgressHUD.create(ChangeMyNickAndHeadActivity.this)
//                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                                .setLabel("Loading...")
//                                .setCancellable(true)
//                                .setAnimationSpeed(2)
//                                .setDimAmount(0.5f)
//                                .show();
//
//                        uploadHead.uploadblock(new UploadFileListener() {
//
//                            @Override
//                            public void done(BmobException e) {
//                                if (e == null) {
//                                    hud.dismiss();
//                                    //把上传完的图片网址得到给到用户
//                                    user.setHeadPortrait(uploadHead.getFileUrl());
//                                    user.update(BmobUser.getCurrentUser(MyUser.class).getObjectId(), new UpdateListener() {
//                                        @Override
//                                        public void done(BmobException e) {
//                                            if (e == null) {
//                                                Toast.makeText(ChangeMyNickAndHeadActivity.this, "更新成功", Toast.LENGTH_LONG).show();
//                                                finish();
//                                            } else {
//                                                Toast.makeText(ChangeMyNickAndHeadActivity.this, "更新失败:" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                                            }
//                                        }
//                                    });
//                                } else {
//                                    Toast.makeText(ChangeMyNickAndHeadActivity.this, "上传头像失败："+e.getLocalizedMessage(), Toast
//                                            .LENGTH_SHORT).show();
//                                }
//
//                            }
//
//                            @Override
//                            public void onProgress(Integer value) {
//                                // 返回的上传进度（百分比）
//                                hud.setProgress(value);
//
//                                Log.i("tarena", "onProgress: "+value);
//                            }
//                        });
//
//
//
//                    }else{
//                        finish();
//                        Toast.makeText(ChangeMyNickAndHeadActivity.this, "修改成功！", Toast.LENGTH_SHORT)
//                                .show();
//                    }
//
//
//
//
//                } else {
//                    Toast.makeText(ChangeMyNickAndHeadActivity.this, "修改失败：" + e
//                            .getLocalizedMessage(), Toast.LENGTH_SHORT)
//                            .show();
//                }
//            }
//        });

    }

    private void pictureSelector() {
        PictureSelector.create(MySetActivity.this)
                .openGallery(PictureMimeType.ofAll())//全部PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .maxSelectNum(1)// 最大图片选择数量 int
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
                    // 图片选择结果回调
                    // PictureSelector.obtainMultipleResult(data);

                    //在界面中显示已经选择回来的图片
                    // Picasso.with(MyApplication.getContext()).load().into(ivMySetImg);
                    Log.i("TAG", "onActivityResult: " + PictureSelector.obtainMultipleResult(data).get(0).getPath());
                    showImage(PictureSelector.obtainMultipleResult(data).get(0).getPath());
                    break;
            }
        }
    }

    private void showImage(final String imagePath) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                File file = new File(imagePath);

                if (file.exists()) {

                    Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                    ivMySetImg.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(MySetActivity.this, "选择头像失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
