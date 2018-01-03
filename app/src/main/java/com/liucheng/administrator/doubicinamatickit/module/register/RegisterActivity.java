package com.liucheng.administrator.doubicinamatickit.module.register;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.User;
import com.liucheng.administrator.doubicinamatickit.util.PhoneNumberUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.tv_include_login_title)
    TextView tvIncludeLoginTitle;
    @BindView(R.id.ib_include_back)
    ImageButton ibIncludeBack;
    @BindView(R.id.et_register_username)
    EditText etRegisterUsername;
    @BindView(R.id.et_register_auth_code)
    EditText etRegisterAuthCode;
    @BindView(R.id.ib_register_auth_code)
    Button ibRegisterAuthCode;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.et_register_again_password)
    EditText etRegisterAgainPassword;
    @BindView(R.id.but_register)
    Button butRegister;
    /**
     * 倒计时
     */
    private CountDownTime timer;

    //手机号
    String phoneNumber;

    //验证码
    String authCode;
    //密码
    String password;
    //确认密码
    String againPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        timer= new CountDownTime(60000, 1000);
    }

    /**
     *
     * 创建一个类继承 CountDownTimer,实现倒计时
     */
    class CountDownTime extends CountDownTimer{

        //构造函数  第一个参数代表总的计时时长  第二个参数代表计时间隔  单位都是毫秒
        public CountDownTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) { //每计时一次回调一次该方法
            ibRegisterAuthCode.setClickable(false);
            ibRegisterAuthCode.setText(l/1000 + "秒后重发");
            ibRegisterAuthCode.setBackgroundColor(getResources().getColor(R.color.gray_500));
        }



        @Override
        public void onFinish() { //计时结束回调该方法
            ibRegisterAuthCode.setClickable(true);
            ibRegisterAuthCode.setText("获取验证码");

            Drawable drawable = getResources().getDrawable(R.drawable.shape_get_auth_code_button);

            ibRegisterAuthCode.setBackground(drawable);

        }
    }


    @OnClick({R.id.ib_include_back, R.id.ib_register_auth_code, R.id.but_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_include_back:
                finish();
                break;
            case R.id.ib_register_auth_code:

                phoneNumber = etRegisterUsername.getText().toString();
                //检查手机号格式
                boolean isMobile = PhoneNumberUtil.isMobile(phoneNumber);

                if (!isMobile) {
                    Toast.makeText(this, "请检查手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                //发送验证码
                BmobSMS.requestSMSCode(phoneNumber, "zouliuqin", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer integer, BmobException e) {
                        if (e == null) {//验证码发送成功
                            timer.start();
                            Toast.makeText(RegisterActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.but_register:
                final String phoneNumber = etRegisterUsername.getText().toString();

                String authCode = etRegisterAuthCode.getText().toString();

                final String password = etRegisterPassword.getText().toString();

                String againPassword = etRegisterAgainPassword.getText().toString();


                //点击注册按钮，先检查数据完整性，再检测验证码是否正确

                if (TextUtils.isEmpty(phoneNumber) ||
                        TextUtils.isEmpty(authCode) ||
                        TextUtils.isEmpty(password) ||
                        TextUtils.isEmpty(againPassword)) {
                    Toast.makeText(this, "请完整数据！", Toast.LENGTH_SHORT).show();
                    return;
                }


                //检查密码和重复密码是否一致
                if (!password.equals(againPassword)) {
                    etRegisterAgainPassword.setTextColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(this, "两次密码不一致！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //注册
                User bu = new User();
                bu.setNickname(phoneNumber);
                bu.setUsername(phoneNumber);
                bu.setPassword(password);
                //默认设置为男
                bu.setGender("1");
                bu.setMobilePhoneNumber(phoneNumber);
                bu.setHeadPortrait("http://bmob-cdn-15880.b0.upaiyun.com/2017/12/25/25942f691d034e92be90b593818b982c.png");
                bu.signOrLogin(authCode, new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if (e == null) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败:" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                break;
        }
    }
}
