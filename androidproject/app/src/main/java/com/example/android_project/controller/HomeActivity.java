package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_project.R;
import com.example.android_project.mapper.UserCarDBHelper;
import com.example.android_project.pojo.Car;
import com.example.android_project.pojo.User;
import com.example.android_project.pojo.UserCar;
import com.example.android_project.service.CarService;
import com.example.android_project.service.UserCarService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint("NonConstantResourceId")
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private final Map<LinearLayout, Class> map = new HashMap<>();
    private LinearLayout home;
    private LinearLayout buy;
    private LinearLayout info;
    private LinearLayout manager;
    private CarService carService;
    private Intent userIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        home = findBind(home, R.id.home, HomeActivity.class);
        buy = findBind(buy, R.id.buyCar, BuyCarActivity.class);
        info = findBind(info, R.id.info, GoodInfoActivity.class);
        manager = findBind(manager, R.id.manager, ManagerActivity.class);
        home.setBackgroundColor(Color.YELLOW);
        carService = new CarService(this);
        userIntent = this.getIntent();
        ListView listView = findViewById(R.id.listview);
        ListAdapter listAdapter = carService.setAdapter();
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), GoodInfoActivity.class);
                Car car = carService.selectById(position + 1);
                intent.putExtra("user", userIntent.getSerializableExtra("user", User.class));
                intent.putExtra("car", car);
                startActivity(intent);
            }
        });
    }

    public LinearLayout findBind(LinearLayout index, int viewById, Class bindClass) {
        index = findViewById(viewById);
        index.setOnClickListener(this);
        map.put(index, bindClass);
        return index;
    }

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
        intent.putExtra("user", userIntent.getSerializableExtra("user", User.class));
        startActivity(intent);
    }
}