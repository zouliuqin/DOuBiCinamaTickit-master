package com.liucheng.administrator.doubicinamatickit.module.findpassword;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ib_register_auth_code, R.id.but_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_register_auth_code:
                //获取验证码
                BmobSMS.requestSMSCode("18707157352", "zouliuqin", new QueryListener<Integer>() {

                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if (ex == null) {//验证码发送成功
                            Toast.makeText(FindPasswordActivity.this, "222", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.but_submit:
                final String code = etRegisterAuthCode.getText().toString();
                final String newPassword = etRegisterPassword.getText().toString();
                final String newPassword2 = etRegisterAgainPassword.getText().toString();
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

                BmobUser.resetPasswordBySMSCode(code, newPassword, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            Toast.makeText(FindPasswordActivity.this, "密码重置成功", Toast.LENGTH_SHORT).show();

                            Log.i("smile", "密码重置成功");



                        } else {
                            Log.i("TAG", "重置失败：code =" + e.getErrorCode() + ",msg = " + e.getLocalizedMessage());
                        }
                    }
                });


        }
    }
}
