package com.example.myapplication2.ddauth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.dingtalk.openauth.utils.DDAuthConstant;

public class DDAuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "1111 ");
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String authCode = intent.getStringExtra(DDAuthConstant.CALLBACK_EXTRA_AUTH_CODE);
        String state = intent.getStringExtra(DDAuthConstant.CALLBACK_EXTRA_STATE);
        String error = intent.getStringExtra(DDAuthConstant.CALLBACK_EXTRA_ERROR);
        Log.d("DDAuthActivity_authCode", authCode); //34cc875f583a381f96b3b85e9694edec
        Log.d("DDAuthActivity_state", state);
        Log.d("DDAuthActivity_error", error);
        if(!TextUtils.isEmpty(authCode) && !TextUtils.isEmpty(state)) {
            // 授权成功
            Log.d("TAG", "3333 ");
            Toast.makeText(DDAuthActivity.this,"授权成功", Toast.LENGTH_SHORT).show();

        } else {
            // 授权失败
            Toast.makeText(DDAuthActivity.this,"授权失败", Toast.LENGTH_SHORT).show();

        }
    }
}
