package com.guessmusic.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.guessmusic.R;
import com.guessmusic.model.User;
import com.guessmusic.model.UserService;

public class RechargeActivity extends Activity {
    private static final String LOG_TAG = "lancelot";
    EditText mEditText;
    Button mButton;
    UserService mUserService;
    User mUser;
    Context mContext = RechargeActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        initUser();
        mEditText = (EditText) findViewById(R.id.recharge_et);
        mButton = (Button) findViewById(R.id.recharge_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRecharge();
            }
        });
    }

    private void initUser() {
        mUserService = new UserService(mContext);
        String username = getIntent().getStringExtra("username");
        int gold =mUserService.getGold(username);
        int level = mUserService.getLevel(username);
        mUser = new User(username,level,gold);
    }

    private void doRecharge() {
        int oldGold = mUser.getGold();
        int rechargeGold = Integer.valueOf(mEditText.getText().toString());
        Log.i(LOG_TAG, "oldGold:" + oldGold + " rechargeGold:" + rechargeGold);
        mUserService.setGold(mUser.getUsername(),oldGold+rechargeGold);
        setResult(RESULT_OK);
        finish();
    }
}
