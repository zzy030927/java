package com.example.android_project.mapper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.android_project.pojo.Car;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Recycle")
public class CarDBHelper extends SQLiteOpenHelper {

    public static CarDBHelper carDBHelper = null;
    private SQLiteDatabase db = null;
    public static final String DB_NAME = "car.db";
    public static final String TABLE_NAME = "car";
    public static int DB_VERSION = 1;

    public CarDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public CarDBHelper(@Nullable Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    public static CarDBHelper getInstance(Context context, int version) {
        if (carDBHelper == null && version > 0) {
            carDBHelper = new CarDBHelper(context, version);
        } else if (carDBHelper == null) {
            carDBHelper = new CarDBHelper(context);
        }
        return carDBHelper;
    }

    public void openWriteLink() {
        if (db == null || !db.isOpen()) {
            db = carDBHelper.getWritableDatabase();
        }
    }

    public void closeLink() {
        if (db != null && db.isOpen()) {
            db.close();
            db = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "icon INTEGER,"
                + "name VARCHAR(20) NOT NULL,"
                + "sale FLOAT NOT NULL,"
                + "info VARCHAR"
                + ");";
        db.execSQL(create_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public boolean insert(Car car) {
        if (selectByCarName(car.getName()) == -1) {
            ContentValues cv = putData(car);
            db.insert(TABLE_NAME, null, cv);
            return true;
        }
        return false;
    }

    public void update(Car car, String condition, String[] args) {
        ContentValues cv = putData(car);
        db.update(TABLE_NAME, cv, condition, args);
    }

    public int selectByCarName(String name) {
        if (name != null) {
            Cursor query = db.query(TABLE_NAME, new String[]{"id"}, "name = ?", new String[]{name}, null, null, null);
            if (query != null) {
                query.moveToFirst();
                if (query.getCount() != 0)
                    return query.getInt(0);
            }
        }
        return -1;
    }

    public List<Car> select() {
        List<Car> cars = new ArrayList<>();
        Cursor query = db.query(TABLE_NAME, new String[]{"icon", "name", "sale", "info"}, null, null, null, null, null);
        if (query.getCount() != 0)
            while (query.moveToNext()) {
                int icon = query.getInt(0);
                String name = query.getString(1);
                float sale = query.getFloat(2);
                String info = query.getString(3);
                cars.add(new Car(icon, name, sale, info));
            }
        return cars;
    }

    public ContentValues putData(Car car) {
        ContentValues cv = new ContentValues();
        cv.put("icon", car.getIcon());
        cv.put("name", car.getName());
        cv.put("sale", car.getSale());
        cv.put("info", car.getInfo());
        return cv;
    }

    public float selectSaleByCarId(int carId) {
        Cursor query = db.query(TABLE_NAME, new String[]{"sale"}, "id = " + carId, null, null, null, null);
        if (query.getCount() != 0)
            query.moveToFirst();
        return query.getFloat(0);
    }

    public Car selectById(int id) {
        Cursor query = db.query(TABLE_NAME, new String[]{"icon", "name", "sale", "info"}, "id = " + id, null, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
        }
        return new Car(query.getInt(0), query.getString(1), query.getFloat(2), query.getString(3));
    }
}
