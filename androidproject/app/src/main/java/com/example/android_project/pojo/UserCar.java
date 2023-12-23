package com.example.android_project.pojo;

public class UserCar {
    int userId;
    int CarId;
    String uuid;
    int status;
    int bought;

    public UserCar(int userId, int carId, String uuid, int status, int bought) {
        this.userId = userId;
        CarId = carId;
        this.uuid = uuid;
        this.status = status;
        this.bought = bought;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }
}

