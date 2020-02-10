package com.example.logindemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.logindemo.R;
import com.example.logindemo.util.MySDKManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //check the user login status
                if(MySDKManager.getInstance().isUserLoggedIn()) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();

                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }

            }
        }, 2000);
    }
}
