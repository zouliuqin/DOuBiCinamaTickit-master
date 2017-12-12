package com.liucheng.administrator.doubicinamatickit.module.login;

import android.content.Intent;
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
import com.liucheng.administrator.doubicinamatickit.entity.User;
import com.liucheng.administrator.doubicinamatickit.module.findpassword.FindPasswordActivity;
import com.liucheng.administrator.doubicinamatickit.module.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.ib_include_back)
    ImageButton ibIncludeBack;
    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R.id.tv_login_find)
    TextView tvLoginFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.but_login, R.id.tv_login_register, R.id.tv_login_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_login:

//
//                BmobSMS.verifySmsCode("18707157352", "975968", new UpdateListener() {
//                    @Override
//                    public void done(BmobException e) {
//                        if(e==null){//短信验证码已验证成功
//                            Log.i("bmob", "验证通过");
//                        }else{
//                            Log.i("bmob", "验证失败：code ="+e.getErrorCode()+",msg = "+e.getLocalizedMessage());
//                        }
//                    }
//                });

                break;
            case R.id.tv_login_register:
                //跳转到注册页面
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_find:
                //跳转到找回密码页面
                Intent intent2 = new Intent(LoginActivity.this,FindPasswordActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
