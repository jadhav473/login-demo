package com.example.logindemo;

import android.app.Application;

import com.example.logindemo.util.MySDKManager;

/**
 * When you open the app, onCreate
 */
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        MySDKManager.initialize(getApplicationContext());
    }
}
