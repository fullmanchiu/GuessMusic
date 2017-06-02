package com.guessmusic.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.guessmusic.R;
import com.guessmusic.model.User;
import com.guessmusic.model.UserService;

public class LoginActivity extends Activity {
    private static final String LOG_TAG = "lancelot";
    private RelativeLayout mLogin, mRegister;
    private EditText etUsername,etPassword;
    private Context mContext = LoginActivity.this;
    private UserService mUserService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogin = (RelativeLayout) findViewById(R.id.login_login);
        mRegister = (RelativeLayout) findViewById(R.id.login_register);
        etUsername = (EditText) findViewById(R.id.login_username);
        etPassword = (EditText) findViewById(R.id.login_password);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, RegisterActivity.class));
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserService = new UserService(mContext);
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (mUserService.login(username,password)) {
                    Intent intent = new Intent(mContext, GuessActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                } else {
                    showToast("登陆失败！");
                }
            }
        });
    }
    private void showToast(String toast) {
        Log.i(LOG_TAG,"showToast");
        Toast.makeText(mContext,toast,Toast.LENGTH_SHORT).show();
    }
}
