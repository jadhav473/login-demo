package com.example.logindemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.logindemo.R;
import com.example.logindemo.constant.APP_CONSTANT;
import com.example.logindemo.data.model.User;
import com.example.logindemo.mvc.GEMSDKManager;

public class MainActivity extends AppCompatActivity {
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set user data
        User user=GEMSDKManager.getInstance().getUser();
        ((TextView)findViewById(R.id.userId)).setText(user.getUserName());
        ((TextView)findViewById(R.id.email)).setText(user.getEmail());
        ((TextView)findViewById(R.id.firstName)).setText(user.getFirstName());
        ((TextView)findViewById(R.id.lastName)).setText(user.getLastName());

        //set logout action

        findViewById(R.id.logoutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GEMSDKManager.getInstance().setUserLoggedIn(false);
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
                //start login activity with clear top
            }
        });

        }
}
