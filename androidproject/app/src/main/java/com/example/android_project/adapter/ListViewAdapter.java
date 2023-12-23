package com.example.android_project.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.example.android_project.R;
import com.example.android_project.pojo.UserCar;
import com.example.android_project.service.CarService;
import com.example.android_project.service.UserCarService;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"SetTextI18n", "DefaultLocale"})
public class ListViewAdapter extends BaseAdapter {

    private static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView sale;
        Button delete;
        ImageView status;
    }

    private final List<Integer> icons;
    private final List<String> names;
    private final List<Float> sales;
    private float sumSale = 0.0F;
    private final Context context;
    private final UserCarService userCarService;
    private final CarService carService;
    private TextView sumView;
    private int userId;
    private List<UserCar> singleUserCars;
    private Button buyButton;
    public ListViewAdapter(ArrayList<Integer> icons, ArrayList<String> names, ArrayList<Float> sales, Context context, TextView sumView, int userId, Button buyButton) {
        this(icons, names, sales, context);
        this.sumView = sumView;
        this.userId = userId;
        this.buyButton = buyButton;
    }

    public ListViewAdapter(ArrayList<Integer> icons, ArrayList<String> names, ArrayList<Float> sales, Context context) {
        this.icons = icons;
        this.names = names;
        this.sales = sales;
        this.context = context;
        userCarService = new UserCarService(context);
        carService = new CarService(context);
    }

    @Override
    public int getCount() {
        //得到数据条目总数
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        //得到id对应对象
        return names.get(i);
    }

    @Override
    public long getItemId(int i) {
        //根据i得到long类型的id
        return (long) i;
    }

    @Override
        // i当前条目的位置
        // converviwe当前条目的视图
        // parent为ListView本身
    public View getView(int i, View converview, ViewGroup parent) {
        // 自定义类，用来缓存当前条目的视图,因为填充的时候会将imageView和textView的布局同时应用到条目中，所以它们两个是一体的，将它俩封装成一个类
        ViewHolder holder = new ViewHolder();
        // 判断当前条目的视图是否为空，如果为空则进行视图创建和填充操作
        if (converview == null) {
        // converview = View.inflate(MainActivity.this, R.layout.fragment_one, null);
            if (context.getClass().getSimpleName().equals("HomeActivity"))
                // 使用布局管理器     将条目的布局文件 转换为View对象
                converview = LayoutInflater.from(context).inflate(R.layout.one_good_display, null);
            else {
                converview = LayoutInflater.from(context).inflate(R.layout.shop_buy_good_one, null);
                holder.delete = converview.findViewById(R.id.cancel);
                holder.status = converview.findViewById(R.id.status);
                singleUserCars = userCarService.getAllStatusByUserId(userId);
                if (sumView != null) {
                    sumSale = 0;
                    if (singleUserCars.size() != 0)
                        for (UserCar singleUserCar : singleUserCars) {
                            if (singleUserCar.getStatus() == 1) {
                                sumSale += carService.selectSaleById(singleUserCar.getCarId());
                            }
                        }
                    sumView.setText("   总计：" + String.format("%.2f", sumSale) + "w");
                }
            }
            // 通过视图对象找到条目中的imageView控件并缓存到ViewHolder中
            holder.icon = (ImageView) converview.findViewById(R.id.icon);
            holder.name = (TextView) converview.findViewById(R.id.name);
            holder.sale = (TextView) converview.findViewById(R.id.sale);
            if (holder.delete != null)
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog alertDialog = new AlertDialog.Builder(context)
                                .setTitle("是否取消加入购物车")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        UserCar userCar = singleUserCars.get(i);
                                        if (userCar.getStatus() == 1) {
                                            sumSale -= carService.selectSaleById(userCar.getCarId());
                                            sumView.setText("   总计：" + String.format("%.2f", sumSale) + "w");
                                        }
                                        userCarService.remove(userCar);
                                        singleUserCars.remove(userCar);
                                        names.remove(i);
                                        icons.remove(i);
                                        sales.remove(i);
                                        notifyDataSetChanged();
                                    }
                                })
                                .setNegativeButton("取消", null).create();
                        alertDialog.show();
                    }
                });
            if (buyButton != null) {
                buyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int j = 0;  singleUserCars.size() > 0 && j < singleUserCars.size(); ) {
                            UserCar userCar = singleUserCars.get(j);
                            if (userCarService.getStatus(userCar.getCarId(), userCar.getUuid()) == 1) {
                                userCarService.updateStatus(userCar);
                                singleUserCars.remove(j);
                                names.remove(j);
                                icons.remove(j);
                                sales.remove(j);
                                notifyDataSetChanged();
                            } else {
                                j++;
                            }
                        }
                        AlertDialog alertDialog = new AlertDialog.Builder(context)
                                                    .setMessage("购买成功")
                                                    .setPositiveButton("确认", null).create();
                        alertDialog.show();
                        sumSale = 0;
                        sumView.setText("   总计：" + String.format("%.2f", sumSale) + "w");
                        notifyDataSetChanged();
                    }
                });
            }
            if (holder.status != null) {
                ViewHolder finalHolder = holder;
                holder.status.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UserCar userCar = singleUserCars.get(i);
                        int status = userCarService.updateStatus(userCar);
                        notifyDataSetChanged();
                        if (status == 0) {
                            finalHolder.status.setImageResource(R.drawable.dui);
                            singleUserCars.get(i).setStatus(1);
                            sumSale += sales.get(i);
                        }
                        else if (status == 1) {
                            finalHolder.status.setImageResource(R.drawable.wei);
                            singleUserCars.get(i).setStatus(0);
                            sumSale -= sales.get(i);
                        }
                        sumView.setText("   总计：" + String.format("%.2f", sumSale) + "w");
                        notifyDataSetChanged();
                    }
                });
            }
            // 将填充好的视图对象和当前的条目相关联起来，方便后续复用
            converview.setTag(holder);
        } else {
            holder = (ViewHolder) converview.getTag();  // 如果视图不空，那么直接从缓存中的ViewHolder对象中获取视图
        }
        // 更换imageView的图片，将其设置为icons[i]的图片
        holder.icon.setBackgroundResource(icons.get(i));
        if (names.get(i) != null)
            holder.name.setText(names.get(i));
        if (sales.get(i) != 0)
            holder.sale.setText(String.valueOf(sales.get(i)) + "w");
        if (holder.status != null && i < singleUserCars.size() && singleUserCars.size() != 0) {
            UserCar userCar = singleUserCars.get(i);
            int status = userCarService.getStatus(userCar.getCarId(), userCar.getUuid());
            holder.status.setImageResource(status == 0 ? R.drawable.wei : R.drawable.dui);
            notifyDataSetChanged();
        }
        return converview;  // 返回填充好的数据的视图对象作为当前条目的视图
    }
}
