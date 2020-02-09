package com.example.logindemo;

import android.app.Application;

import com.example.logindemo.mvc.GEMSDKManager;

/**
 * When you open the app, onCreate
 */
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        GEMSDKManager.initialize(getApplicationContext());
    }
}
