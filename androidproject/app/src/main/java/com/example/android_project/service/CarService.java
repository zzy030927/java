package com.example.android_project.service;

import android.content.Context;
import android.view.View;
import com.example.android_project.adapter.ListViewAdapter;
import com.example.android_project.mapper.CarDBHelper;
import com.example.android_project.pojo.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final CarDBHelper carDBHelper;
    private final Context context;

    public CarService(Context context) {
        carDBHelper = CarDBHelper.getInstance(context, 1);
        this.context = context;
        //打开数据库帮助器的写连接
        carDBHelper.openWriteLink();
    }

    public void insert(List<Car> cars) {
        for (Car car : cars) {
            carDBHelper.insert(car);
        }
    }

    public List<Car> select() {
        return carDBHelper.select();
    }

    public ListViewAdapter setAdapter() {
        List<Car> cars = select();
        int len = cars != null && cars.size() != 0 ? cars.size() : 1;
        ArrayList<Integer> icons = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Float> sales = new ArrayList<>();
        if (cars != null) {
            for (Car car : cars) {
                icons.add(car.getIcon());
                names.add(car.getName());
                sales.add(car.getSale());
            }
        }
        icons.add(0);
        names.add("");
        sales.add(0F);
        return new ListViewAdapter(icons, names, sales, context);
    }

    public Car selectById(int id) {
        return carDBHelper.selectById(id);
    }

    public void updateByCarName(Car car) {
        carDBHelper.update(car, "name = ?", new String[]{car.getName()});
    }

    public int selectByCarName(String carName) {
        return carDBHelper.selectByCarName(carName);
    }

    public float selectSaleById(int carId) {
        return carDBHelper.selectSaleByCarId(carId);
    }
}
