package com.example.android_project.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.example.android_project.adapter.ListViewAdapter;
import com.example.android_project.mapper.CarDBHelper;
import com.example.android_project.mapper.UserCarDBHelper;
import com.example.android_project.mapper.UserDBHelper;
import com.example.android_project.pojo.Car;
import com.example.android_project.pojo.UserCar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UserCarService {
    private final UserCarDBHelper userCarDBHelper;
    private final Context context;
    private final UserDBHelper userDBHelper;
    private final CarDBHelper carDBHelper;

    public UserCarService(Context context) {
        this.context = context;
        userCarDBHelper = UserCarDBHelper.getInstance(context, 1);
        userCarDBHelper.openWriteLink();

        userDBHelper = UserDBHelper.getInstance(context, 1);
        userDBHelper.openWriteLink();

        carDBHelper = CarDBHelper.getInstance(context, 1);
        carDBHelper.openWriteLink();
    }

    public String insert(UserCar userCar) {
        return userCarDBHelper.insert(userCar);
    }

    public ListAdapter setAdapter(String username, TextView textView, Button buyButton) {
        int userId = userDBHelper.selectByUsername(username);
        List<UserCar> userCars = userCarDBHelper.selectUserCars(userId);
        ArrayList<Integer> icons = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Float> sales = new ArrayList<>();
        int i = 0;
        if (userCars != null) {
            for (; i < userCars.size(); i++) {
                UserCar userCar = userCars.get(i);
                int bought = userCar.getBought();
                if (bought == 0) {
                    Car car = carDBHelper.selectById(userCar.getCarId());
                    icons.add(car.getIcon());
                    names.add(car.getName());
                    sales.add(car.getSale());
                }
            }
        }
        return new ListViewAdapter(icons, names, sales, context, textView, userId, buyButton);
    }

    public void remove(UserCar userCar) {
        userCarDBHelper.deleteByCarId(userCar.getCarId(), userCar.getUuid());
    }

    public int updateStatus(UserCar userCar) {
        int status = getStatus(userCar.getCarId(), userCar.getUuid());
        int updateStatus = -1;
        if (status == 0)
            updateStatus = 1;
        else if (status == 1)
            updateStatus = 0;
        userCarDBHelper.updateStatus(userCar.getCarId(), userCar.getUuid(), updateStatus, 1);
        return status;
    }

    public int getStatus(int carId, String date) {
        return userCarDBHelper.selectStatus(carId, date);
    }

    public List<UserCar> getAllStatusByUserId(int userId) {
        return userCarDBHelper.getCarsByUserId(userId);
    }

    public List<Car> selectAllBoughtCar(String username) {
        int userId = userDBHelper.selectByUsername(username);
        List<Integer> carIdList = userCarDBHelper.selectBoughtCars(userId);
        List<Car> carList = new ArrayList<>();
        if (carIdList.size() != 0) {
            for (Integer carId : carIdList) {
                carList.add(carDBHelper.selectById(carId));
            }
        }
        return carList;
    }
}
