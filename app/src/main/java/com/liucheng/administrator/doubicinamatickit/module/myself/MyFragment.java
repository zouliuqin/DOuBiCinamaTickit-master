package com.liucheng.administrator.doubicinamatickit.module.myself;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.User;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.basicsettings.BasicSettingsActivity;
import com.liucheng.administrator.doubicinamatickit.module.feedback.FeedbackActivity;
import com.liucheng.administrator.doubicinamatickit.module.login.LoginActivity;
import com.liucheng.administrator.doubicinamatickit.ui.MainActivity;
import com.liucheng.administrator.doubicinamatickit.util.FastBlurUtil;
import com.liucheng.administrator.doubicinamatickit.util.Utils;
import com.squareup.picasso.Picasso;

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
    @BindView(R.id.ll_my_fragment_my_head_portrait)
    LinearLayout llMyFragmentMyHeadPortrait;
    @BindView(R.id.fl_my_fragment)
    FrameLayout flMyFragment;
    @BindView(R.id.iv_head_portrait)
    CircleImageView ivHeadPortrait;

    private boolean isLogin = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.my_fragment, container, false);


        unbinder = ButterKnife.bind(this, contentView);

        return contentView;
    }


    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_my);

        initiaActionBar(-1, null, "个人中心", R.drawable.setting);
        //如果用户登录了 则修改为  用户名称
        User user = BmobUser.getCurrentUser(User.class);
        if (user != null) {
            isLogin = true;
            tvMyIsloginOrUsername.setText(user.getNickname());
            //修改头像
            if (user.getHeadPortrait()!=null){
                //如果用户设置了头像则用用户的头像

                Picasso.with(getContext()).load(user.getHeadPortrait()).into(ivHeadPortrait);
            }else {
                //如果用户没有设置头像使用默认头像
                ivHeadPortrait.setImageResource(R.drawable.ic_login_default_head_portraits);
            }


        } else {
            isLogin = false;
            tvMyIsloginOrUsername.setText("点击登录");
        }
        //加载本地模糊背景
       // dimImage();
    }

    /**
     * 本地模糊
     */
    private void dimImage() {
        //得到原始图片
        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.myself_bg);
        int scaleRatio = 100;
        int blurRadius = 80;//模糊度 越大越模糊
        //将图片进行缩放 避免OOM错误
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originBitmap,
                originBitmap.getWidth() / scaleRatio,
                originBitmap.getHeight() / scaleRatio,
                false);
      //  Bitmap blurBitmap = Utils.doBlur(scaledBitmap, blurRadius, true);
        Bitmap blurBitmap=  FastBlurUtil.doBlur(scaledBitmap,blurRadius,true);
       Drawable a = new BitmapDrawable(this.getResources(),blurBitmap);

        flMyFragment.setBackground(a);


    }

    /**
     * 网络模糊
     *
     * @param img 地址
     */
    private void dimImage(final String img) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int scaleRatio = 0;
                String pattern = "8";
                if (TextUtils.isEmpty(pattern)) {
                    scaleRatio = 0;
                } else if (scaleRatio < 0) {
                    scaleRatio = 10;
                } else {
                    scaleRatio = Integer.parseInt(pattern);
                }
                // 下面的这个方法必须在子线程中执行
                final Bitmap blurBitmap2 = FastBlurUtil.GetUrlBitmap(img, scaleRatio);


                // 刷新ui必须在主线程中执行
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Drawable a = new BitmapDrawable(blurBitmap2);
                        flMyFragment.setBackground(a);
                    }
                });
            }
        }).start();


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageView_actionbar, R.id.ll_wanna_see, R.id.ll_have_seen, R.id.ll_invite_friends, R.id.ll_setting, R.id.ll_feedback, R.id.ll_about_us, R.id.ll_my_fragment_my_head_portrait})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_actionbar:
                //判断用户是否登录。如果没有登录 跳转到登录界面，如果登录了 跳转到编辑个人资料页面

                if (isLogin) {
                    Intent intent2 = new Intent(getActivity(), MySetActivity.class);
                    startActivity(intent2);
                } else {
                    Toast.makeText(getActivity(), "请先登录！", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent2);
                }
                break;
            case R.id.ll_my_fragment_my_head_portrait:

                if (!isLogin) {

                    Toast.makeText(getActivity(), "请先登录！", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent2);
                }

                break;
            case R.id.ll_wanna_see:
                //TODO  想看的电影
                break;
            case R.id.ll_have_seen:
                //TODO  看过的电影
                break;
            case R.id.ll_invite_friends:
                // 分享给好友
                shareMsg("易迅电影", null, "免费应用-最新电影资讯:www.yixunmovie.com");

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
        // 退出登录后要重新检查用户是否登录，如果没有登录 则修改界面为未登录样式
        initialUI();
    }

    /**
     * @param activityTitle 分享列表标题
     * @param msgTitle      消息标题
     * @param msgText       内容
     */
    public void shareMsg(String activityTitle, String msgTitle, String msgText) {
        Intent intent = new Intent(Intent.ACTION_SEND);// 系统分享功能
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);// 分享的内容
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, activityTitle));// 目标应用选择对话框的标题


    }


}
