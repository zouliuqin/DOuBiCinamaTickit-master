package com.liucheng.administrator.doubicinamatickit.module.findpassword;

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
import com.liucheng.administrator.doubicinamatickit.module.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class FindPasswordActivity extends AppCompatActivity {

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
    @BindView(R.id.but_submit)
    Button butSubmit;
    /**
     * 倒计时
     */
    private CountDownTime timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        ButterKnife.bind(this);

        timer= new CountDownTime(60000, 1000);
    }
    /**
     *
     * 创建一个类继承 CountDownTimer,实现倒计时
     */
    class CountDownTime extends CountDownTimer {

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


    @OnClick({R.id.ib_register_auth_code, R.id.but_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_register_auth_code:
                //获取验证码
                BmobSMS.requestSMSCode(etRegisterUsername.getText().toString(), "zouliuqin", new QueryListener<Integer>() {

                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if (ex == null) {//验证码发送成功
                            timer.start();
                            Toast.makeText(FindPasswordActivity.this, "短信发送成功！", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.i("TAG", "done: " + ex);
                            Toast.makeText(FindPasswordActivity.this, "发送异常！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.but_submit:
                String code = etRegisterAuthCode.getText().toString();
                String newPassword = etRegisterPassword.getText().toString();
               String newPassword2 = etRegisterAgainPassword.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(newPassword)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newPassword.equals(newPassword2)) {
                    Toast.makeText(this, "请确认两次密码一致", Toast.LENGTH_SHORT).show();
                    return;
                }


                Log.i("TAG", "onViewClicked: " + code);
                Log.i("TAG", "onViewClicked: " + newPassword);
                BmobUser.resetPasswordBySMSCode(code, newPassword, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            Toast.makeText(FindPasswordActivity.this, "密码重置成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(FindPasswordActivity.this, "重置失败：code =" + e.getErrorCode() + ",msg = " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        }
    }
}
