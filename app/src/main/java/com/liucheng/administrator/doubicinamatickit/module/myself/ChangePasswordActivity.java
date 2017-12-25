package com.liucheng.administrator.doubicinamatickit.module.myself;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class ChangePasswordActivity extends AppCompatActivity {

    @BindView(R.id.tv_include_login_title)
    TextView tvIncludeLoginTitle;
    @BindView(R.id.ib_include_back)
    ImageButton ibIncludeBack;
    @BindView(R.id.et_change_password_old_password)
    EditText etChangePasswordOldPassword;
    @BindView(R.id.et_change_password_new_password)
    EditText etChangePasswordNewPassword;
    @BindView(R.id.et_change_password_confirm_password)
    EditText etChangePasswordConfirmPassword;
    @BindView(R.id.but_change_password_submit)
    Button butChangePasswordSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
        initUi();
    }

    private void initUi() {
        //修改标题
        tvIncludeLoginTitle.setText("修改密码");

    }


    @OnClick({R.id.ib_include_back, R.id.but_change_password_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_include_back:
                finish();
                break;
            case R.id.but_change_password_submit:
                //获取新密码和确认密码是否一致。
                String newPassword = etChangePasswordNewPassword.getText().toString();
                String confirmPassword = etChangePasswordConfirmPassword.getText().toString();
                String oldPassword = etChangePasswordOldPassword.getText().toString();

                if (TextUtils.isEmpty(newPassword) ||
                        TextUtils.isEmpty(confirmPassword) ||
                        TextUtils.isEmpty(oldPassword)) {
                    Toast.makeText(this, "请检查数据！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!confirmPassword.equals(newPassword)) {
                    Toast.makeText(this, "新的密码确认密码不一致，请检查", Toast.LENGTH_SHORT).show();
                    return;
                }
                BmobUser.updateCurrentUserPassword(oldPassword, newPassword, new UpdateListener() {

                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            Toast.makeText(ChangePasswordActivity.this, "密码修改成功，可以用新密码进行登录啦", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ChangePasswordActivity.this, "修改失败:" + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }

                });
                break;
        }
    }
}
