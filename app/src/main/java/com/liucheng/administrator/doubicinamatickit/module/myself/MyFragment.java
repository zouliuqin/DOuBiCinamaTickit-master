package com.liucheng.administrator.doubicinamatickit.module.myself;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.basicsettings.BasicSettingsActivity;
import com.liucheng.administrator.doubicinamatickit.module.feedback.FeedbackActivity;
import com.liucheng.administrator.doubicinamatickit.module.login.LoginActivity;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class MyFragment extends BaseFragment {


    @BindView(R.id.im_my_fragment_bg)
    ImageView imMyFragmentBg;
    @BindView(R.id.iv_my_fragment_my_head_portrait)
    CircleImageView ivMyFragmentMyHeadPortrait;
    Unbinder unbinder;
    @BindView(R.id.imageView_actionbar)
    ImageView imageViewActionbar;
    @BindView(R.id.tv_my_islogin_or_username)
    TextView tvMyIsloginOrUsername;
    @BindView(R.id.ll_wanna_see)
    LinearLayout llWannaSee;
    @BindView(R.id.ll_have_seen)
    LinearLayout llHaveSeen;
    @BindView(R.id.ll_invite_friends)
    LinearLayout llInviteFriends;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;
    @BindView(R.id.ll_feedback)
    LinearLayout llFeedback;
    @BindView(R.id.ll_about_us)
    LinearLayout llAboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.my_fragment, container, false);
        initialUI();

        unbinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_my);

        initiaActionBar(-1, null, "个人中心", R.drawable.setting);
        ivMyFragmentMyHeadPortrait = contentView.findViewById(R.id.iv_my_fragment_my_head_portrait);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageView_actionbar, R.id.iv_my_fragment_my_head_portrait, R.id.ll_wanna_see, R.id.ll_have_seen, R.id.ll_invite_friends, R.id.ll_setting, R.id.ll_feedback, R.id.ll_about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_actionbar:
                //判断用户是否登录。如果没有登录 跳转到登录界面，如果登录了 跳转到编辑个人资料页面

                BmobUser bmobUser = BmobUser.getCurrentUser();
                if (bmobUser != null) {
                    Intent intent2 = new Intent(getActivity(), MySetActivity.class);
                    startActivity(intent2);
                } else {
                    Toast.makeText(getActivity(), "请先登录！", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent2);
                }


                break;
            case R.id.iv_my_fragment_my_head_portrait:
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_wanna_see:
                //TODO  想看的电影
                break;
            case R.id.ll_have_seen:
                //TODO  看过的电影
                break;
            case R.id.ll_invite_friends:
                //TODO  分享给好友
                shareMsg("易迅电影", null, "免费应用-最新电影资讯:www.yixun_movie .com");

                break;
            case R.id.ll_setting:
                //  基本设置

                startActivity(new Intent(getActivity(), BasicSettingsActivity.class));
                break;
            case R.id.ll_feedback:
                //  反馈
                startActivity(new Intent(getActivity(), FeedbackActivity.class));
                break;
            case R.id.ll_about_us:
                //TODO  关于我们
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        //TODO  退出登录后要重新检查用户是否登录，如果没有登录 则修改界面为未登录样式
    }

    /**
     * @param activityTitle 分享列表标题
     * @param msgTitle      消息标题
     * @param msgText       内容
     */
    public void shareMsg(String activityTitle, String msgTitle, String msgText) {
        Intent intent = new Intent(Intent.ACTION_SEND);// 系统分享功能
       // File f = new File(Environment.getExternalStorageDirectory() + "/ic_qr.png");
        intent.setType("text/plain");
      //  intent.setType("image/*");// 分享发送的数据类型
//        Uri u = Uri.fromFile(f);
//        intent.putExtra(Intent.EXTRA_STREAM, u);
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);// 分享的内容
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, activityTitle));// 目标应用选择对话框的标题

//        Intent intent = new Intent(Intent.ACTION_SEND);// 系统分享功能
//        if (imgPath == null || imgPath.equals("")) {
//            intent.setType("text/plain"); // 纯文本,// 分享发送的数据类型
//        } else {
//            File f = new File(imgPath);
//            if (f != null && f.exists() && f.isFile()) {
//                intent.setType("image/jpg");// 分享发送的数据类型
//                Uri u = Uri.fromFile(f);
//                intent.putExtra(Intent.EXTRA_STREAM, u);
//            }
//        }
//        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
//        intent.putExtra(Intent.EXTRA_TEXT, msgText);// 分享的内容
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(Intent.createChooser(intent, activityTitle));// 目标应用选择对话框的标题


    }


}
