package com.guessmusic.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.guessmusic.R;
import com.guessmusic.model.User;
import com.guessmusic.model.UserService;

public class RegisterActivity extends Activity implements View.OnClickListener {
    private static final String LOG_TAG = "lancelot";
    private EditText etUsername, etPwd, etPwd2;
    private Button btnRegister;
    private UserService mUserService;
    Context mContext = RegisterActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = (EditText) findViewById(R.id.register_username);
        etPwd = (EditText) findViewById(R.id.register_pwd);
        etPwd2 = (EditText) findViewById(R.id.register_pwd_con);
        btnRegister = (Button) findViewById(R.id.register_btn);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                Log.i(LOG_TAG,"onclick");
                doRegister();
                break;
            default:
        }
    }

    private void doRegister() {
        String username = etUsername.getText().toString();
        String password = etPwd.getText().toString();
        String password2 = etPwd2.getText().toString();
        Log.i(LOG_TAG,"username:" + username + " password:"+password);
        if ("".equals(username)) {
            showToast("用户名不能为空！");
            return;
        }
        if ("".equals(password) || "".equals(password2)) {
            showToast("密码不能为空！");
            return;
        }
        if (!password.equals(password2)) {
            showToast("密码输入不一致，请检查！");
            return;
        }
        writeUserInfoToDatabase(username,password);
        finish();
    }

    private void writeUserInfoToDatabase(String username, String password) {
        mUserService = new UserService(mContext);
        User user = new User(username,password,0,0);
        mUserService.register(user);
    }

    private void showToast(String toast) {
        Log.i(LOG_TAG,"showToast");
        Toast.makeText(mContext,toast,Toast.LENGTH_SHORT).show();
    }
}
