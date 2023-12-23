package com.example.android_project.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_project.R;
import com.example.android_project.pojo.Car;
import com.example.android_project.pojo.User;
import com.example.android_project.pojo.UserCar;
import com.example.android_project.service.CarService;
import com.example.android_project.service.LoginService;
import com.example.android_project.service.UserCarService;

import java.util.*;

@SuppressLint({"NonConstantResourceId", "MissingInflatedId", "SetTextI18n"})
public class GoodInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private final Map<LinearLayout, Class> map = new HashMap<>();
    private LinearLayout home;
    private LinearLayout buy;
    private LinearLayout info;
    private LinearLayout manager;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_info);
        home = findBind(home, R.id.home, HomeActivity.class);
        buy = findBind(buy, R.id.buyCar, BuyCarActivity.class);
        info = findBind(info, R.id.info, GoodInfoActivity.class);
        manager = findBind(manager, R.id.manager, ManagerActivity.class);

        TextView carNameView = findViewById(R.id.carName);
        ImageView carIconView = findViewById(R.id.carSrc);
        TextView carSaleView = findViewById(R.id.carSale);
        TextView carInfoView = findViewById(R.id.carInfo);
        Button addInShopView = findViewById(R.id.addInShop);
        Button buyShopView = findViewById(R.id.buy);

        AlertDialog alertDialog = new AlertDialog.Builder(this).setPositiveButton("确认", null).create();
        Intent intent = getIntent();
        Car car = intent.getSerializableExtra("car", Car.class);
        UserCarService userCarService = new UserCarService(this);
        CarService carService = new CarService(this);
        LoginService loginService = new LoginService(this);
        info.setBackgroundColor(Color.YELLOW);
        if (car == null) {
            car = carService.selectById(1);
        }
        carNameView.setText(car.getName());
        carIconView.setImageResource(car.getIcon());
        carSaleView.setText(String.valueOf(car.getSale()) + "w");
        carInfoView.setText("    " + car.getInfo());

        user = intent.getSerializableExtra("user", User.class);
        String username = user != null ? user.getUsername() : "111";
        Car shopCar = intent.getSerializableExtra("car", Car.class);
        String carName = shopCar != null ? shopCar.getName() : "宝马1系";
        int userId = loginService.selectByUserName(username);
        int carId = carService.selectByCarName(carName);
        addInShopView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCarService.insert(new UserCar(userId, carId, UUID.randomUUID().toString(), 0, 0));
                alertDialog.setTitle("添加成功");
                alertDialog.show();
            }
        });
        buyShopView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCarService.insert(new UserCar(userId, carId, UUID.randomUUID().toString(), -1, 1));
                alertDialog.setTitle("购买成功");
                alertDialog.show();
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
        intent.putExtra("user", user);
        startActivity(intent);
    }
}