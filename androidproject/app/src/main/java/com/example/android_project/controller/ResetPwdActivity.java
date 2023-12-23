package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_project.R;
import com.example.android_project.pojo.User;
import com.example.android_project.service.LoginService;

@SuppressLint("MissingInflatedId")
public class ResetPwdActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resetPwd;
    private TextView surePwd;
    private Intent intent;
    private LoginService loginService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpwd);
        resetPwd = findViewById(R.id.resetPwd);
        surePwd = findViewById(R.id.sureInputPwd);
        Button sure = findViewById(R.id.sure);
        Button cancel = findViewById(R.id.cancel);
        sure.setOnClickListener(this);
        cancel.setOnClickListener(this);
        loginService = new LoginService(this);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setPositiveButton("确认", null)
                .create();
        intent = this.getIntent();
    }

    @Override
    public void onClick(View v) {
        boolean resetRes = false;
        if (v.getId() == R.id.sure) {
            String resetPwdContext = resetPwd.getText().toString();
            String surePwdContext = surePwd.getText().toString();
            User user = intent.getSerializableExtra("user", User.class);
            resetRes = loginService.resetPwd(user, surePwdContext, resetPwdContext);
        }
        if (resetRes || v.getId() == R.id.cancel) {
            Intent returnIntent = new Intent(v.getContext(), LoginActivity.class);
            startActivity(returnIntent);
        }
    }
}