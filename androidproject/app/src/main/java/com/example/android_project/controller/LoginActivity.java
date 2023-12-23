package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_project.R;
import com.example.android_project.pojo.User;
import com.example.android_project.service.LoginService;

@SuppressLint({"ResourceType", "WrongViewCast", "NonConstantResourceId"})
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private LoginService loginService;
    private TextView username;
    private TextView pwd;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView reset = findViewById(R.id.tv_find_psw);
        Button login = findViewById(R.id.btn_login);
        Button register = findViewById(R.id.tv_register);
        username = findViewById(R.id.et_user_name);
        pwd = findViewById(R.id.et_psw);
        loginService = new LoginService(LoginActivity.this);
        reset.setOnClickListener(this);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        user = new User(username.getText().toString().trim(), pwd.getText().toString().trim());
        switch (v.getId()) {
            case R.id.btn_login: if (loginService.login(user)) jump(HomeActivity.class, user);break;
            case R.id.tv_register: if (loginService.register(user)) {
                new AlertDialog.Builder(v.getContext()).setTitle("注册成功").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        jump(HomeActivity.class, user);
                    }
                }).show();
            }break;
            case R.id.tv_find_psw: jump(ResetPwdActivity.class, user);break;
        }
    }
    public void jump(Class<?> cls, User user) {
        Intent intent = new Intent(LoginActivity.this, cls);
        if (user != null)
            intent.putExtra("user", user);
        startActivity(intent);
    }
}

