package com.example.logindemo.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.logindemo.data.model.User;


public class MySDKManager
{

    private static String TAG  = MySDKManager.class.getName();
    @SuppressLint("StaticFieldLeak") private static MySDKManager myinstance = null;
    private Context context;
    private MySharedPreferences mySharedPreferences;

    private MySDKManager(Context context)
    {
        try
        {
            this.context = context;
            this.mySharedPreferences = new MySharedPreferences();
            this.mySharedPreferences.init(context);
            Log.i(TAG, "initialized successfully");
        }
        catch(Throwable t)
        {
            t.printStackTrace();
            Log.e(TAG, "can't be instantiated", t);
        }

    }


    public static void initialize(Context context)
    {
        if(myinstance == null)
        {
            myinstance = new MySDKManager(context);
        }

    }


    public static MySDKManager getInstance()
    {
        return myinstance;
    }

    public Context getContext()
    {
        return this.context;
    }

    public MySharedPreferences getSharedPreferences()
    {
        return this.mySharedPreferences;
    }

    public boolean isUserLoggedIn()
    {
        return this.mySharedPreferences.getUserLoginStatus();
    }

    public void setUserLoggedIn(boolean userStatus)
    {
        mySharedPreferences.setUserLoginStatus(userStatus);
    }

    public void toastShort(final String msg)
    {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable()
        {
            public void run()
            {
                Toast.makeText(MySDKManager.this.context, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toastLong(final String msg)
    {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable()
        {
            public void run()
            {
                Toast.makeText(MySDKManager.this.context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void saveUser(User user)
    {
        mySharedPreferences.saveUser(user);
    }

    public User getUser()
    {
        return  mySharedPreferences.getUser();
    }
}