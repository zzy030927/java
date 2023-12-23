package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_project.R;
import com.example.android_project.pojo.User;

import java.util.HashMap;
import java.util.Map;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private final Map<LinearLayout, Class> map = new HashMap<>();
    private LinearLayout home;
    private LinearLayout buy;
    private LinearLayout info;
    private LinearLayout manager;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);
        home = findBind(home, R.id.home, HomeActivity.class);
        buy = findBind(buy, R.id.buyCar, BuyCarActivity.class);
        info = findBind(info, R.id.info, GoodInfoActivity.class);
        manager = findBind(manager, R.id.manager, ManagerActivity.class);
        manager.setBackgroundColor(Color.YELLOW);

        TextView usernameView = findViewById(R.id.name);
        LinearLayout editPwdView = findViewById(R.id.editPwd);
        LinearLayout historyView = findViewById(R.id.history);
        Intent intent = getIntent();
        User user = intent.getSerializableExtra("user", User.class);
        if (user == null)
            user = new User("111", "222");
        usernameView.setText(user.getUsername());
        User finalUser = user;
        editPwdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToReset = new Intent(v.getContext(), ResetPwdActivity.class);
                jumpToReset.putExtra("user", finalUser);
                startActivity(jumpToReset);
            }
        });
        historyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToReset = new Intent(v.getContext(), BoughtGoodInfo.class);
                jumpToReset.putExtra("user", finalUser);
                startActivity(jumpToReset);
            }
        });
    }

    public LinearLayout findBind(LinearLayout index, int viewById, Class bindClass) {
        index = findViewById(viewById);
        index.setOnClickListener(this);
        map.put(index, bindClass);
        return index;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        LinearLayout toPage = null;
        switch (v.getId()) {
            case R.id.home: toPage = home;break;
            case R.id.buyCar: toPage = buy;break;
            case R.id.info: toPage = info;break;
            case R.id.manager: toPage = manager;break;
        }
        Intent intent = new Intent(v.getContext(), map.get(toPage));
        startActivity(intent);
    }
}