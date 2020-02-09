package com.example.logindemo.util;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.example.logindemo.data.model.User;
import com.google.gson.Gson;

public class MySharedPreferences
{
    private static final String PREF_SHARED_RESOURCE_NAME = "my-preference";
    private static final String USER_LOGIN_STATUS = "userLoginStatus";
    private static final String USER = "user";

    private static SharedPreferences sharedPreferences;


    public MySharedPreferences()
    {
    }


    void init(Context context)
    {
        sharedPreferences =
                context.getSharedPreferences(PREF_SHARED_RESOURCE_NAME, Context.MODE_PRIVATE);
    }

    public void putData(String key, Object val)
    {
        if(key != null && val != null)
        {
            Editor sharedPreferencesEditor = sharedPreferences.edit();
            if(val instanceof String)
            {
                sharedPreferencesEditor.putString(key, val.toString());
            }
            else if(val instanceof Integer)
            {
                sharedPreferencesEditor.putInt(key, (Integer) val);
            }
            else if(val instanceof Long)
            {
                sharedPreferencesEditor.putLong(key, (long) ((Long) val).intValue());
            }
            else if(val instanceof Float)
            {
                sharedPreferencesEditor.putFloat(key, (Float) val);
            }
            else if(val instanceof Boolean)
            {
                sharedPreferencesEditor.putBoolean(key, (Boolean) val);
            }

            sharedPreferencesEditor.apply();
        }
    }

    public Object getData(String key)
    {
        return key == null ? null : sharedPreferences.getAll().get(key);
    }


    public boolean has(String key)
    {
        return sharedPreferences.contains(key);
    }

    public void cleanAllPreference()
    {
        sharedPreferences.edit().clear().apply();
    }

    public boolean getUserLoginStatus()
    {
        if(sharedPreferences.contains(USER_LOGIN_STATUS))
        {
            return sharedPreferences.getBoolean(USER_LOGIN_STATUS, false);
        }
        return false;
    }

    public void setUserLoginStatus(boolean userLoginStatus)
    {
        putData(USER_LOGIN_STATUS, userLoginStatus);
    }

    public void saveUser(User user)
    {
        Gson gson = new Gson();
        String userString = gson.toJson(user);
        putData(USER, userString);
    }

    public User getUser()
    {
        Gson gson = new Gson();
        String userString= (String) getData(USER);
        User user=gson.fromJson(userString,User.class);
        return user;
    }
}