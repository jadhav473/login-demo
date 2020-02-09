package com.example.logindemo.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.logindemo.constant.APP_CONSTANT;
import com.example.logindemo.data.model.User;
import com.example.logindemo.listener.AuthListener;

public class UserViewModel extends ViewModel {
    public String userId="",password="";
    private AuthListener authListener;

    public void onLoginClick(View view)
    {
        String errMsg = validate();

        if(errMsg.isEmpty())
        {
            //it means there is no error

            //try for login
            if(userId.equals(APP_CONSTANT.userId) && password.equals(APP_CONSTANT.password))
            {
                authListener.onLoginSuccess(new User(APP_CONSTANT.userId,APP_CONSTANT.userName,"Vishal","Jadhav","jadhav473@gmail.com"));
            }
            else
            {
                authListener.onLoginFailed("UserId or Password may be wrong");
            }
        }
        else
        {
            //show error or give error callback
            authListener.onLoginFailed(errMsg);
        }

    }

    public void setAuthListener(AuthListener authListener)
    {
        this.authListener = authListener;
    }

    private String validate()
    {
        //check if username is valid
        if(userId ==null || userId.isEmpty())
        {
            return "userId cannot be empty";
        }else if(password==null || password.isEmpty())
        {
            return  "password cannot be empty";
        }
        // TODO: 09-02-2020 length or expression validation or else any validation

        return "";
    }

}
