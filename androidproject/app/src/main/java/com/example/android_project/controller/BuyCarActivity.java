package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_project.R;
import com.example.android_project.pojo.Car;
import com.example.android_project.pojo.User;
import com.example.android_project.service.UserCarService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BuyCarActivity extends AppCompatActivity implements View.OnClickListener {

    private final Map<LinearLayout, Class> map = new HashMap<>();
    private LinearLayout home;
    private LinearLayout buy;
    private LinearLayout info;
    private LinearLayout manager;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_car);
        home = findBind(home, R.id.home, HomeActivity.class);
        buy = findBind(buy, R.id.buyCar, BuyCarActivity.class);
        info = findBind(info, R.id.info, GoodInfoActivity.class);
        manager = findBind(manager, R.id.manager, ManagerActivity.class);
        TextView textView = findViewById(R.id.sum);
        UserCarService userCarService = new UserCarService(this);
        buy.setBackgroundColor(Color.YELLOW);
        Intent intent = getIntent();
        user = intent.getSerializableExtra("user", User.class);
        if (user == null)
            user = new User("111", "222");
        ListView listView = findViewById(R.id.listview);
        ListAdapter listAdapter = userCarService.setAdapter(user.getUsername(), textView, findViewById(R.id.buy));
        listView.setAdapter(listAdapter);
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
        intent.putExtra("user", user);
        startActivity(intent);
    }
}