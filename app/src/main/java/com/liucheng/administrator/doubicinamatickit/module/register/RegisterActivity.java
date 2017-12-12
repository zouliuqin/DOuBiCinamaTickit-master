package com.liucheng.administrator.doubicinamatickit.module.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.util.PhoneNumberUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.ib_include_back, R.id.ib_register_auth_code, R.id.but_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_include_back:
                finish();
                break;
            case R.id.ib_register_auth_code:

                String  phoneNumber = etRegisterUsername.getText().toString();


                //检查手机号格式
                boolean  isMobile =  PhoneNumberUtil.isMobile(phoneNumber);
                if (!isMobile){
                    Toast.makeText(this, "请检查手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                    //发送验证码
                BmobSMS.requestSMSCode(phoneNumber, "zouliuqin", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer integer, BmobException e) {
                        if (e == null) {//验证码发送成功
                            Toast.makeText(RegisterActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.but_register:
                break;
        }
    }
}
