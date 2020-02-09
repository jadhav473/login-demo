package com.example.logindemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.logindemo.R;
import com.example.logindemo.data.model.User;
import com.example.logindemo.databinding.ActivityLoginBinding;
import com.example.logindemo.listener.AuthListener;
import com.example.logindemo.util.MySDKManager;
import com.example.logindemo.viewmodel.UserViewModel;

public class LoginActivity extends AppCompatActivity implements AuthListener
{
    private ActivityLoginBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.setAuthListener(this);
        binding.setUserViewModel(userViewModel);
        getSupportActionBar().hide();
    }


    @Override
    public void onLoginSuccess(User user) {

        MySDKManager.getInstance().toastShort("Login Successfully");

        //save the user's state as logged in user
        MySDKManager.getInstance().setUserLoggedIn(true);

        //save user data
        MySDKManager.getInstance().saveUser(user);

        //we can pass user id through intent but we are not passing it as we are handling it through our SDKManager util
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    @Override
    public void onLoginFailed(String errorMsg) {
        MySDKManager.getInstance().toastShort(errorMsg);
    }
}
