package com.example.android_project.mapper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.android_project.pojo.User;
import com.example.android_project.pojo.UserCar;

import java.util.*;

@SuppressLint({"Recycle", "SimpleDateFormat"})
public class UserCarDBHelper extends SQLiteOpenHelper {
    public static UserCarDBHelper userCarDBHelper = null;
    private SQLiteDatabase db = null;
    public static final String DB_NAME = "car.db";
    public static final String TABLE_NAME = "user_car";
    public static int DB_VERSION = 1;
    public UserCarDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public UserCarDBHelper(@Nullable Context context, int version) {
        super(context, DB_NAME, null, version);
    }


    public static UserCarDBHelper getInstance(Context context, int version) {
        if (userCarDBHelper == null && version > 0) {
            userCarDBHelper = new UserCarDBHelper(context, version);
        } else if (userCarDBHelper == null) {
            userCarDBHelper = new UserCarDBHelper(context);
        }
        return userCarDBHelper;
    }

    public void openWriteLink() {
        if (db == null || !db.isOpen()) {
            db = userCarDBHelper.getWritableDatabase();
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
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "user_id INTEGER,"
                + "car_id INTEGER,"
                + "status INTEGER,"
                + "uuid VARCHAR"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String insert(UserCar userCar) {
        ContentValues cv = putData(userCar);
        db.insert(TABLE_NAME, null, cv);
        return cv.getAsString("date");
    }

    public List<UserCar> selectUserCars(int userId) {
        Cursor query = db.query(TABLE_NAME, new String[]{"user_id", "car_id", "status", "uuid", "bought"}, "user_id = " + userId, null, null, null, null);
        List<UserCar> userCars = new ArrayList<>();
        while (query.moveToNext()) {
            userCars.add(new UserCar(query.getInt(0), query.getInt(1), query.getString(3), query.getInt(2), query.getInt(4)));
        }
        return userCars;
    }

    public void deleteByCarId(int carId, String uuid) {
        db.delete(TABLE_NAME, "car_id = " + carId + " AND uuid = ?", new String[]{uuid});
    }

    public int selectStatus(int carId, String uuid) {
        Cursor query = db.query(TABLE_NAME, new String[]{"status"}, "car_id = " + carId + " AND uuid = ?", new String[]{uuid}, null, null, null);
        if (query.getCount() == 0)
            return 0;
        query.moveToFirst();
        return query.getInt(0);
    }

    public void updateStatus(int carId, String uuid, int status, int bought) {
        ContentValues cv = new ContentValues();
        cv.put("status", status);
        cv.put("bought", bought);
        db.update(TABLE_NAME, cv, "car_id = " + carId + " AND uuid = ?", new String[]{uuid});
    }

    public List<UserCar> getCarsByUserId(int userId) {
        Cursor query = db.query(TABLE_NAME, new String[]{"user_id", "car_id", "uuid", "status"}, "user_id = " + userId + " AND bought = 0", null, null, null, null);
        List<UserCar> userCars = new ArrayList<>();
        if (query.getCount() != 0) {
            while (query.moveToNext()) {
                userCars.add(new UserCar(query.getInt(0), query.getInt(1), query.getString(2), query.getInt(3), 0));
            }
        }
        return userCars;
    }

    public void updateBought(UserCar userCar) {
        db.execSQL("UPDATE user_car SET bought = 1 WHERE car_id = " + userCar.getUserId() + " AND uuid = \"" + userCar.getUuid() + "\"");
    }

    public ContentValues putData(UserCar userCar) {
        ContentValues cv = new ContentValues();
        cv.put("user_id", userCar.getUserId());
        cv.put("car_id", userCar.getCarId());
        cv.put("uuid", userCar.getUuid());
        cv.put("status", userCar.getStatus());
        cv.put("bought", userCar.getBought());
        return cv;
    }

    public List<Integer> selectBoughtCars(int userId) {
        Cursor query = db.query(TABLE_NAME, new String[]{"car_id"}, "user_id = " + userId + " AND bought = 1", null, null, null, null);
        List<Integer> carIdList = new ArrayList<>();
        if (query.getCount() != 0) {
            while (query.moveToNext()) {
                carIdList.add(query.getInt(0));
            }
        }
        return carIdList;
    }

    public int selectBoughtCar(int carId, String uuid) {
        Cursor query = db.query(TABLE_NAME, new String[]{"bought"}, "car_id = " + carId + " AND uuid = \"" + uuid +"\"", null, null, null, null);
        query.moveToFirst();
        return query.getInt(0);
    }
}
