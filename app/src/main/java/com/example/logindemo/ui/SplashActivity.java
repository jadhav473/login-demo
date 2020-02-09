package com.example.logindemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.logindemo.R;
import com.example.logindemo.mvc.GEMSDKManager;


/**
 * This screen will decide where to go
 * if user is not logged in then show him login activity else main activity
 *
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(GEMSDKManager.getInstance().isUserLoggedIn())
                {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();

                }
                else
                {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }

            }
        }, 2000);
    }
}
