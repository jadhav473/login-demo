package com.example.logindemo.listener;

import com.example.logindemo.data.model.User;

public interface AuthListener
{
    void onLoginSuccess(User user);
    void onLoginFailed(String errorMsg);
}
