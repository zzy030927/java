package com.example.android_project.pojo;

import java.io.Serializable;

public class Car implements Serializable {
    private int icon;
    private String name;
    private float sale;
    private String info;

    public Car(int icon, String name, float sale, String info) {
        this.icon = icon;
        this.name = name;
        this.sale = sale;
        this.info = info;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
