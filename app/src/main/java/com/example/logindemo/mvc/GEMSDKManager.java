package com.example.logindemo.mvc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.logindemo.data.model.User;


public class GEMSDKManager
{

    private static String TAG  = GEMSDKManager.class.getName();
    @SuppressLint("StaticFieldLeak") private static GEMSDKManager myinstance = null;
    private Context context;
    private GEMSharedPreferences gemSharedPreferences;

    private GEMSDKManager(Context context)
    {
        try
        {
            this.context = context;
            this.gemSharedPreferences = new GEMSharedPreferences();
            this.gemSharedPreferences.init(context);
            Log.i(TAG, " SDK is initialized successfully");
        }
        catch(Throwable t)
        {
            t.printStackTrace();
            Log.e(TAG, "GEM SDK can't be instantiated", t);
        }

    }


    public static void initialize(Context context)
    {
        if(myinstance == null)
        {
            myinstance = new GEMSDKManager(context);
        }

    }


    public static GEMSDKManager getInstance()
    {
        return myinstance;
    }

    public Context getContext()
    {
        return this.context;
    }

    public GEMSharedPreferences getSharedPreferences()
    {
        return this.gemSharedPreferences;
    }

    public boolean isUserLoggedIn()
    {
        return this.gemSharedPreferences.getUserLoginStatus();
        // return this.getUserName() != null && this.getPassword() != null && this.getLastLoginTimeInMillis() > -1L && this.getUserProfile() != null;
    }

    public void setUserLoggedIn(boolean userStatus)
    {
        gemSharedPreferences.setUserLoginStatus(userStatus);
    }




    public void toastShort(final String msg)
    {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable()
        {
            public void run()
            {
                Toast.makeText(GEMSDKManager.this.context, msg, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(GEMSDKManager.this.context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void saveUser(User user)
    {
        gemSharedPreferences.saveUser(user);
    }

    public User getUser()
    {
        return  gemSharedPreferences.getUser();
    }
}