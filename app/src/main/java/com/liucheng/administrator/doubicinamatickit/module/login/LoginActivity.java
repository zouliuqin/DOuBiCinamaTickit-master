package com.liucheng.administrator.doubicinamatickit.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {


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
    @BindView(R.id.ib_include_back)
    ImageButton ibIncludeBack;

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
                //判断用户名和密码不为空
                if (TextUtils.isEmpty(etLoginUsername.getText().toString()) ||
                        TextUtils.isEmpty(etLoginPassword.getText().toString())) {
                    Toast.makeText(this, "请检查用户名或密码！", Toast.LENGTH_SHORT).show();
                    return;
                }

                User bu2 = new User();
                bu2.setUsername(etLoginUsername.getText().toString());
                bu2.setPassword(etLoginPassword.getText().toString());
                bu2.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            //登录成功
                            Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                            //当前页面finish;
                            finish();
                            //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                            //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                        } else {
                            Toast.makeText(LoginActivity.this, "登录失败！请检查用户名或者密码！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.tv_login_register:
                //跳转到注册页面
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_find:
                //跳转到找回密码页面
                Intent intent2 = new Intent(LoginActivity.this, FindPasswordActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @OnClick(R.id.ib_include_back)
    public void onViewClicked() {
        finish();
    }
}
