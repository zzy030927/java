package com.example.android_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android_project.R;
import com.example.android_project.pojo.Car;

import java.util.ArrayList;
import java.util.List;

public class BoughtListViewAdapter extends BaseAdapter {
    private class ViewHolder {
        ImageView icon;
        TextView name;
        TextView sale;
    }

    private List<Integer> icons = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private List<Float> sales = new ArrayList<>();
    private final Context context;

    public BoughtListViewAdapter(List<Car> cars, Context context) {
        for (Car car : cars) {
            icons.add(car.getIcon());
            names.add(car.getName());
            sales.add(car.getSale());
        }
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return names.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long) i;
    }

    @Override
    public View getView(int i, View converview, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (converview == null) {
            converview = LayoutInflater.from(context).inflate(R.layout.one_good_display, null);
            holder.icon = (ImageView) converview.findViewById(R.id.icon);
            holder.name = (TextView) converview.findViewById(R.id.name);
            holder.sale = (TextView) converview.findViewById(R.id.sale);
            converview.setTag(holder);
        } else {
            holder = (ViewHolder) converview.getTag();
        }
        holder.icon.setBackgroundResource(icons.get(i));
        holder.name.setText(names.get(i));
        holder.sale.setText(String.valueOf(sales.get(i)) + "w");
        return converview;  // 返回填充好的数据的视图对象作为当前条目的视图
    }
}
