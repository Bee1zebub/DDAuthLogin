package com.example.myapplication2;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.android.dingtalk.openauth.AuthLoginParam;
import com.android.dingtalk.openauth.DDAuthApiFactory;
import com.android.dingtalk.openauth.IDDAuthApi;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ImageButton btn = this.findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Onclick()...", "钉钉授权登录开始");
                AuthLoginParam.AuthLoginParamBuilder builder = AuthLoginParam.AuthLoginParamBuilder.newBuilder();
                builder.appId(AuthLoginConstant.AppId);
                builder.redirectUri(AuthLoginConstant.RedirectUri);
                builder.responseType(AuthLoginConstant.responseType);
                builder.scope(AuthLoginConstant.scope);
                builder.nonce(AuthLoginConstant.nonce); //选填
                builder.state(AuthLoginConstant.state);
                builder.prompt(AuthLoginConstant.prompt);
                IDDAuthApi authApi = DDAuthApiFactory.createDDAuthApi(context, builder.build());
                authApi.authLogin();

            }
        });
    }
}