package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_project.R;
import com.example.android_project.adapter.BoughtListViewAdapter;
import com.example.android_project.pojo.Car;
import com.example.android_project.pojo.User;
import com.example.android_project.service.UserCarService;

import java.util.List;

public class BoughtGoodInfo extends AppCompatActivity {

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bought_good_list);
        ListView listView = findViewById(R.id.listview);
        Button back = findViewById(R.id.back);
        UserCarService userCarService = new UserCarService(this);
        User user = getIntent().getSerializableExtra("user", User.class);
        List<Car> cars = userCarService.selectAllBoughtCar(user.getUsername());
        BoughtListViewAdapter boughtListViewAdapter = new BoughtListViewAdapter(cars, this);
        listView.setAdapter(boughtListViewAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ManagerActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}